package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailActivity extends AppCompatActivity {

    ImageButton back;
    ImageView likeBtn;
    ImageView saveBtn;
    ImageView profilePhoto;
    TextView author;
    ImageView postImage;
    TextView postText;
    TextView date;
    TextView likesCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        back = findViewById(R.id.back);
        likeBtn = findViewById(R.id.likeBtn);
        saveBtn = findViewById(R.id.saveBtn);
        profilePhoto = findViewById(R.id.profilePhoto);
        author = findViewById(R.id.author);
        postImage = findViewById(R.id.postImage);
        postText = findViewById(R.id.postText);
        date = findViewById(R.id.date);
        likesCnt = findViewById(R.id.likesCnt);

        final News news = (News)getIntent().getSerializableExtra("news");
        final int index = getIntent().getIntExtra("index", 0);

        profilePhoto.setImageResource(news.getProfilePhoto());
        postImage.setImageResource(news.getPostImage());

        author.setText(news.getAuthor());
        String s = "<b>"+ news.getAuthor() + "</b>" + " " + news.getPostText();
        postText.setText(Html.fromHtml(s));
        date.setText(news.getDate());
        likesCnt.setText(news.getLikesCnt()+" likes");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsDetailActivity.this, MainActivity.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!news.isLiked()){
                    likeBtn.setImageResource(R.drawable.liked);
                    news.setLiked(true);
                } else {
                    likeBtn.setImageResource(R.drawable.like);
                    news.setLiked(false);
                }
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!news.isSaved()){
                    saveBtn.setImageResource(R.drawable.saved);
                    news.setSaved(true);
                } else {
                    saveBtn.setImageResource(R.drawable.save);
                    news.setSaved(false);
                }
            }
        });
    }
}
