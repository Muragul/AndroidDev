package com.example.hw4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {

    var back: ImageButton? = findViewById(R.id.back)
    var profilePhoto: ImageView? = findViewById(R.id.profilePhoto)
    var author: TextView? = findViewById(R.id.author)
    var postImage: ImageView? = findViewById(R.id.postImage)
    var postText: TextView? = findViewById(R.id.postText)
    var date: TextView? = findViewById(R.id.date)
    var likesCnt: TextView? = findViewById(R.id.likesCnt)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val news = intent.getSerializableExtra("news") as News
        val index = intent.getIntExtra("index", 0)
        profilePhoto?.setImageResource(news.profilePhoto)
        postImage?.setImageResource(news.postImage)
        author?.text = news.author
        val s = "<b>" + news.author + "</b>" + " " + news.postText
        postText?.text = Html.fromHtml(s)
        date?.text = news.date
        likesCnt?.text = news.likesCnt.toString() + " likes"

        back?.setOnClickListener {
            val intent = Intent(this@NewsDetailActivity, MainActivity::class.java)
            intent.putExtra("index", index)
            startActivity(intent)
        }

    }
}
