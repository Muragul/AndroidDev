package com.example.inst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton ibLike;
    ImageButton ibSave;
    ImageButton ibMore;
    boolean liked = false;
    boolean saved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibLike = findViewById(R.id.ib5);
        ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!liked){
                    ibLike.setImageResource(R.drawable.liked);
                    liked = true;
                } else {
                    ibLike.setImageResource(R.drawable.like);
                    liked = false;
                }
            }
        });

        ibSave = findViewById(R.id.ib8);
        ibSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!saved){
                    ibSave.setImageResource(R.drawable.saved);
                    saved = true;
                } else {
                    ibSave.setImageResource(R.drawable.save);
                    saved = false;
                }
            }
        });

        ibMore = findViewById(R.id.ib4);
        ibMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "You have opened Menu",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}
