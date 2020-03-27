package com.example.iviapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(){
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("news", 1)
            intent.putExtra("index", 1)
            startActivity(intent)
        }
    }
}
