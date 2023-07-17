package com.pachchham.pagenatoin.Interface

import com.pachchham.pagenatoin.Modal.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface3 {

    @GET("top_rated")
    fun getTpoRated(
        @Query("page")page : Int
    ) :Call<MovieModel>
}