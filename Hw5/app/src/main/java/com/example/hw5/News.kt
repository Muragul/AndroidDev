package com.example.hw5

import java.io.Serializable

class News(
    var author: String,
    var date: String,
    var profilePhoto: Int,
    var likesCnt: Int,
    var postImage: Int,
    var postText: String
) : Serializable{

}