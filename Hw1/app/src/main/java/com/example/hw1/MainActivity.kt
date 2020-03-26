package com.example.hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var author: TextView
    private lateinit var profileImg: ImageView
    private lateinit var postImg: ImageView
    private lateinit var likes: TextView
    private lateinit var text: TextView
    private lateinit var comments: TextView
    private lateinit var date: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        author = findViewById(R.id.author)
        author.text = "comely.vintage"

        profileImg = findViewById(R.id.profilePhoto)
        profileImg.setImageResource(R.drawable.profile17)

        postImg = findViewById(R.id.postImage)
        postImg.setImageResource(R.drawable.post17)

        likes = findViewById(R.id.likesCnt)
        likes.text = "9,389 likes"

        text = findViewById(R.id.postText)
        text.text = Html.fromHtml("<b>comely.vintage</b> \uD835\uDC3C\uD835\uDCC3\uD835\uDCC8\uD835\uDCC5\uD835\uDCBE\uD835\uDCC7\uD835\uDCB6\uD835\uDCC9\uD835\uDCBE\uD835\uDC5C\uD835\uDCC3 \n" +
                "#comelyvintage\n" +
                "~ via: @samsonthedood")

        comments = findViewById(R.id.comments)
        comments.text = "View all 165 comments"

        date = findViewById(R.id.date)
        date.text = "December 9, 2019"

    }
}
