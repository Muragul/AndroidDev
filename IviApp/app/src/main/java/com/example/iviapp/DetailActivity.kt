package com.example.iviapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.iviapp.model.Movie

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val poster: ImageView = findViewById(R.id.poster)
        Glide.with(this).load(intent.extras?.getString("backdrop_path")).into(poster)

        val movieTitle: TextView = findViewById(R.id.title)
        movieTitle.text = intent.extras?.getString("original_title")

        val releaseDate: TextView = findViewById(R.id.releasedate)
        releaseDate.text = intent.extras?.getString("release_date")

        val adult: TextView = findViewById(R.id.adult)
        if (intent.getBooleanExtra("adult", false)){
            adult.text = "18+"
        } else {
            adult.text = "No"
        }

        val rating: TextView = findViewById(R.id.rate)
        rating.text = intent.extras?.getString("vote_average")

        val popularity: TextView = findViewById(R.id.popularity)
        popularity.text = intent.extras?.getString("popularity")

        val overview: TextView = findViewById(R.id.overview)
        overview.text = intent.extras?.getString("overview")

        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}