package com.example.films

import com.example.films.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebService {
    private val retrofit: Retrofit
    val service: GithubService
        get() = retrofit.create(GithubService::class.java)

    init {
        retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create()).build()
    }
}