package com.example.hw4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val news: News = intent.getSerializableExtra("news") as News
        val position: Int = intent.getIntExtra("index", 0)

        val profilePhoto: ImageView = findViewById(R.id.profilePhoto)
        Glide.with(this).load(news.profilePhoto).into(profilePhoto)
        val postImage: ImageView = findViewById(R.id.postImage)
        Glide.with(this).load(news.postImage).into(postImage)
        val author: TextView = findViewById(R.id.author)
        author.text = news.author
        val postText: TextView = findViewById(R.id.postText)
        val s = "<b>" + news.author + "</b>" + " " + news.postText
        postText.text = Html.fromHtml(s)
        val date: TextView = findViewById(R.id.date)
        date.text = news.date
        val likesCnt: TextView = findViewById(R.id.likesCnt)
        likesCnt.text = news.likesCnt.toString() + " likes"
        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("index", position)
            startActivity(intent)
        }
    }
}
