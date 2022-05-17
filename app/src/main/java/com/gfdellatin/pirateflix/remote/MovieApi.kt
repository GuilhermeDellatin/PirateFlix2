package com.gfdellatin.pirateflix.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/discover/movie")
    suspend fun getMovies(@Query("api_key") tmdbToken: String) : BaseResponse<List<MovieResponse>>
}