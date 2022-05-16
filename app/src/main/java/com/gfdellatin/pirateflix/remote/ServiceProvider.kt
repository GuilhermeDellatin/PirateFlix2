package com.gfdellatin.pirateflix.remote

import retrofit2.Retrofit

private const val baseUrl = "https://api.themoviedb.org/3/"

object ServiceProvider {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .build()

    val service = retrofit.create(MovieApi::class.java)
}