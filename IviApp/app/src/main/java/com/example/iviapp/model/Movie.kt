package com.example.iviapp.model

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("poster_path")
    private var posterPath: String? = null

    @SerializedName("adult")
    private var adult = false

    @SerializedName("overview")
    private var overview: String? = null

    @SerializedName("release_date")
    private var releaseDate: String? = null

    @SerializedName("genre_ids")
    private var genreIds: List<Int> = ArrayList()

    @SerializedName("id")
    private var id: Int? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("original_language")
    private var originalLanguage: String? = null

    @SerializedName("title")
    private var title: String? = null

    @SerializedName("backdrop_path")
    private var backdropPath: String? = null

    @SerializedName("popularity")
    private var popularity: Double? = null

    @SerializedName("vote_count")
    private var voteCount: Int? = null

    @SerializedName("video")
    private var video: Boolean? = null

    @SerializedName("vote_average")
    var voteAverage: Double? = null


    private var baseImageUrl: String = "https://image.tmdb.org/t/p/w500"

    fun getPosterPath():String {
        return baseImageUrl + posterPath
    }
}