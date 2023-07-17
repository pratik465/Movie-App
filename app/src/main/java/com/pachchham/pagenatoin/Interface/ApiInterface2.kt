package com.pachchham.pagenatoin.Interface

import com.pachchham.pagenatoin.Modal.MovieModel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface2 {

    @GET("now_playing")
    fun getNowPlaying(
        @Query("page")page : Int
    ) :Call<MovieModel>
}