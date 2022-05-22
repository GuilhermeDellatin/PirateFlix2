package com.gfdellatin.pirateflix.data.api

import com.gfdellatin.pirateflix.data.model.BasePaginationRemote
import com.gfdellatin.pirateflix.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverAPI {

    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") token: String): BasePaginationRemote<List<MovieResponse>>

}