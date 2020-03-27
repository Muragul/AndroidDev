package com.example.hw4

import java.io.Serializable

class News: Serializable{
    var author: String = ""
    var date: String = ""
    var profilePhoto: Int = 0
    var likesCnt: Int = 0
    var postImage: Int = 0
    var postText: String = ""
    var isLiked: Boolean = false
    var isSaved: Boolean = false

    constructor(
        author: String,
        date: String,
        profilePhoto: Int,
        likesCnt: Int,
        postImage: Int,
        postText: String
    ) {
        this.author = author
        this.date = date
        this.profilePhoto = profilePhoto
        this.likesCnt = likesCnt
        this.postImage = postImage
        this.postText = postText
    }
}