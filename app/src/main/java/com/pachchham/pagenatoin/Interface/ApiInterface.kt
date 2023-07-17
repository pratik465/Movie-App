package com.pachchham.pagenatoin.Interface

import com.pachchham.pagenatoin.Modal.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("popular")
    fun getPopular(
        @Query("page")page : Int
    ) :Call<MovieModel>

    @GET("now_playing")
    fun getNowPlaying(
        @Query("page")page : Int
    ) :Call<MovieModel>

    @GET("top_rated")
    fun getTpoRated(
        @Query("page")page : Int
    ) :Call<MovieModel>

    @GET("upcoming")
    fun getUpcoming(
        @Query("page")page : Int
    ) :Call<MovieModel>

}