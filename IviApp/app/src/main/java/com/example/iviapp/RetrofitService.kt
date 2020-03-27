package com.example.iviapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitService {
    const val BASE_URL = "https://api.themoviedb.org/3"

    fun getMovieApi(): MovieApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MovieApi::class.java)
    }
}

interface MovieApi{
    @GET("movies")
    fun getMovieList(): Call<List<Movie>>
}