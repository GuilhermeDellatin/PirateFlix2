package com.gfdellatin.pirateflix.remote

import com.gfdellatin.pirateflix.data.model.BasePaginationRemote
import com.gfdellatin.pirateflix.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/discover/movie")
    suspend fun getMovies(@Query("api_key") tmdbToken: String) : BasePaginationRemote<List<MovieResponse>>
}