package com.example.films

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/movie?api_key=$KEY")
    fun getTotalResults(
            @Query("langage") langue: String?,
            @Query("query") query: String?
    ): Call<ListFilms?>? /*
         @GET ("search/movie?api_key=e84136321de9a56bbbf7498f847034ea/{id}")
        Call<ListFilms> getTotalResults(
            @Path("id") int id ,
            @Query("language") String langue,
            @Query("query") String query
            &language=fr&query=harry
    );
     */

    companion object {
        const val KEY = "e84136321de9a56bbbf7498f847034ea"
    }
}