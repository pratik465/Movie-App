package com.pachchham.pagenatoin.Interface

import com.pachchham.pagenatoin.Modal.PopularMovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("popular")
    fun getPopularMovie(
        @Query("page")page : Int
    ) :Call<PopularMovieModel>
}