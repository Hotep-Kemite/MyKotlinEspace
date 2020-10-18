package com.example.films

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListFilms {
    @SerializedName("page")
    @Expose
    var page = 0

    @SerializedName("total_results")
    @Expose
    var totalResults = 0

    @SerializedName("total_pages")
    @Expose
    var totalPages = 0

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

    fun getResult(i: Int): Result {
        return results!![i]
    }
}