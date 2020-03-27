package com.example.hw4

import android.annotation.SuppressLint
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.lang.Exception

class NewsListAdapter(private var newsList: List<News>, private var listener: ItemClickListener):
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    interface ItemClickListener {
        fun itemClick(position: Int, item: News)
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(
            parent.context
        )
            .inflate(
                R.layout.item_news,
                null,
                false
            )
        val params = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.profilePhoto.setImageResource(news.profilePhoto)
        holder.postImage.setImageResource(news.postImage)
        holder.author.text = news.author
        val s = "<b>" + news.author + "</b>" + " " + news.postText
        holder.postText.text = Html.fromHtml(s)
        holder.date.text = news.date
        holder.likesCnt.text = news.likesCnt.toString() + " likes"
        holder.isLiked = news.isLiked
        holder.isSaved = news.isSaved

        holder.itemView.setOnClickListener {
            if (listener!=null) {
                listener.itemClick(position, news)
            }
        }
    }

    class NewsViewHolder(itemView: View) : ViewHolder(itemView) {
        var author: TextView = itemView.findViewById(R.id.author)
        var likesCnt: TextView = itemView.findViewById(R.id.likesCnt)
        var postText: TextView = itemView.findViewById(R.id.postText)
        var date: TextView = itemView.findViewById(R.id.date)
        var postImage: ImageView = itemView.findViewById(R.id.postImage)
        var profilePhoto: ImageView = itemView.findViewById(R.id.profilePhoto)
        private var likeBtn: ImageView = itemView.findViewById(R.id.likeBtn)
        private var saveBtn: ImageView = itemView.findViewById(R.id.saveBtn)
        var isLiked = false
        var isSaved = false

        init {
            likeBtn.setOnClickListener {
                isLiked = if (!isLiked) {
                    likeBtn.setImageResource(R.drawable.liked)
                    true
                } else {
                    likeBtn.setImageResource(R.drawable.like)
                    false
                }
            }
            saveBtn.setOnClickListener {
                if (!isSaved) {
                    saveBtn.setImageResource(R.drawable.saved)
                    isSaved = true
                } else {
                    saveBtn.setImageResource(R.drawable.save)
                }
            }
        }
    }
}