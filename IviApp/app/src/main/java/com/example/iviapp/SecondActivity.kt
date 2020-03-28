package com.example.iviapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.iviapp.adapter.MoviesAdapter
import com.example.iviapp.model.Movie
import com.example.iviapp.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class SecondActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var adapter: MoviesAdapter? = null
    private lateinit var movieList: List<Movie>
    private lateinit var swipeContainer: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()

        swipeContainer = findViewById(R.id.main_content)
        swipeContainer.setOnRefreshListener {
            initViews()
        }
    }

    private fun initViews(){
        recyclerView = findViewById(R.id.recycler_view)

        movieList = ArrayList()
        adapter = MoviesAdapter(this,movieList)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.itemAnimator=DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter?.notifyDataSetChanged()

        loadJSON()
    }

    private fun loadJSON() {
        try {
            if (BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty()) {
                return
            }
            RetrofitService.getPostApi().getTopRatedMovieList(BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .enqueue(object : Callback<MoviesResponse> {
                    override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                        swipeContainer.isRefreshing = false
                    }

                    override fun onResponse(
                        call: Call<MoviesResponse>,
                        response: Response<MoviesResponse>
                    ) {
                        Log.d("My_post_list", response.body().toString())
                        if (response.isSuccessful) {
                            val list = response.body()?.getResults()
                            adapter?.movieList = list as List<Movie>
                            adapter?.notifyDataSetChanged()
                        }
                        swipeContainer.isRefreshing = false

                    }
                })
        } catch (e: Exception){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



}
