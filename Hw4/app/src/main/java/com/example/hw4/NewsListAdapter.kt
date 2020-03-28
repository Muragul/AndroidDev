package com.example.hw4

import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(var newsList: List<News>):
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(
            parent.context
        )
            .inflate(
                R.layout.item_news,
                parent,
                false
            )
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = newsList?.size

    override fun onBindViewHolder(holder: NewsListAdapter.NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    inner class NewsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(news: News?) {
            val author: TextView = view.findViewById(R.id.author)
            var likesCnt: TextView = view.findViewById(R.id.likesCnt)
            var postText: TextView = view.findViewById(R.id.postText)
            var date:TextView = view.findViewById(R.id.date)
            var postImage: ImageView = view.findViewById(R.id.postImage)
            var profilePhoto:ImageView = view.findViewById(R.id.profilePhoto)

            if (news != null) {
                Glide.with(view.context).load(news.profilePhoto).into(profilePhoto)
                Glide.with(view.context).load(news.postImage).into(postImage)
                author.text = news.author
                val s = "<b>" + news.author + "</b>" + " " + news.postText
                postText.text = Html.fromHtml(s)
                date.text = news.date
                likesCnt.text = news.likesCnt.toString() + " likes"
            }

            view.setOnClickListener {
                val intent = Intent(view.context, NewsDetailActivity::class.java)
                intent.putExtra("news", news)
                intent.putExtra("index", newsList.indexOf(news))
                view.context.startActivity(intent)
            }

        }
    }
}