package com.example.newsfeed;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class News implements Serializable {
    private String author;
    private String date;
    private int profilePhoto;
    private int likesCnt;
    private int postImage;
    private String postText;
    private boolean isLiked;
    private boolean isSaved;

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public News(String author, String date, int profilePhoto, int likesCnt, int postImage, String postText) {
        this.author = author;
        this.date = date;
        this.profilePhoto = profilePhoto;
        this.likesCnt = likesCnt;
        this.postImage = postImage;
        this.postText = postText;
        this.isLiked = false;
        this.isSaved = false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getLikesCnt() {
        return likesCnt;
    }

    public void setLikesCnt(int likesCnt) {
        this.likesCnt = likesCnt;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}
