package com.example.newsfeed;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {
    private List<News> newsList;
    private @Nullable ItemClickListener listener;

    public NewsListAdapter(List<News> newsList, @Nullable ItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext())
                .inflate(
                        R.layout.item_news,
                        null,
                        false);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {
        final News news = newsList.get(position);
        holder.profilePhoto.setImageResource(news.getProfilePhoto());
        holder.postImage.setImageResource(news.getPostImage());
        holder.author.setText(news.getAuthor());
        String s = "<b>"+ news.getAuthor()+ "</b>" + " "+ news.getPostText();
        holder.postText.setText(Html.fromHtml(s));
        holder.date.setText(news.getDate());
        holder.likesCnt.setText(news.getLikesCnt()+" likes");
        holder.isLiked = news.isLiked();
        holder.isSaved = news.isSaved();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null)
                    listener.ItemClick(position, news);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView author;
        TextView likesCnt;
        TextView postText;
        TextView date;
        ImageView postImage;
        ImageView profilePhoto;
        ImageView likeBtn;
        ImageView saveBtn;
        boolean isLiked;
        boolean isSaved;

        public NewsViewHolder(@NonNull final View itemView){
            super(itemView);
            author = itemView.findViewById(R.id.author);
            likesCnt = itemView.findViewById(R.id.likesCnt);
            postImage = itemView.findViewById(R.id.postImage);
            postText = itemView.findViewById(R.id.postText);
            date = itemView.findViewById(R.id.date);
            profilePhoto = itemView.findViewById(R.id.profilePhoto);
            likeBtn = itemView.findViewById(R.id.likeBtn);
            saveBtn = itemView.findViewById(R.id.saveBtn);

            likeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isLiked){
                        likeBtn.setImageResource(R.drawable.liked);
                        isLiked = true;
                    } else {
                        likeBtn.setImageResource(R.drawable.like);
                        isLiked = false;
                    }
                }
            });
            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isSaved){
                        saveBtn.setImageResource(R.drawable.saved);
                        isSaved = true;
                    } else {
                        saveBtn.setImageResource(R.drawable.save);
                    }
                }
            });
        }
    }

    interface ItemClickListener{
        void ItemClick(int position, News item);
    }
}
