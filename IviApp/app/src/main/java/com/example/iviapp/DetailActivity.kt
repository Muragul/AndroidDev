package com.example.iviapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.iviapp.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val poster: ImageView = findViewById(R.id.poster)
        val movieTitle: TextView = findViewById(R.id.title)
        val releaseDate: TextView = findViewById(R.id.releasedate)
        val adult: TextView = findViewById(R.id.adult)
        val rating: TextView = findViewById(R.id.rate)
        val popularity: TextView = findViewById(R.id.popularity)
        val back: ImageButton = findViewById(R.id.back)
        val overview: TextView = findViewById(R.id.overview)

        val id = intent.extras?.getInt("movie_id", 0)
        lateinit var mov: Movie
        var call: Call<Movie>? = id?.let { RetrofitService.getPostApi().getMovie(it, BuildConfig.THE_MOVIE_DB_API_TOKEN) }
        call?.enqueue(object : Callback<Movie>{
            override fun onFailure(call: Call<Movie>, t: Throwable) {
            }
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful){
                    Glide.with(this@DetailActivity).load(response.body()?.getBackdropPath()).into(poster)
                    movieTitle.text = response.body()?.originalTitle
                    releaseDate.text = response.body()?.releaseDate
                    if (response.body()?.adult!!){
                        adult.text = "18+"
                    } else {
                        adult.text = "No"
                    }
                    rating.text = response.body()?.voteAverage.toString()
                    popularity.text = response.body()?.popularity.toString()
                    overview.text = response.body()?.overview
                }
            }
        })
        /*
        not server but intent

        Glide.with(this).load(intent.extras?.getString("backdrop_path")).into(poster)
        movieTitle.text = intent.extras?.getString("original_title")
        releaseDate.text = intent.extras?.getString("release_date")
        if (intent.getBooleanExtra("adult", false)){
            adult.text = "18+"
        } else {
            adult.text = "No"
        }
        rating.text = intent.extras?.getString("vote_average")
        popularity.text = intent.extras?.getString("popularity")
        overview.text = intent.extras?.getString("overview")

         */

        back.setOnClickListener{
            onBackPressed()
        }
    }
}