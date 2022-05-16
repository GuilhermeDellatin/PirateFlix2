package com.gfdellatin.pirateflix.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

private const val baseUrl = "https://api.themoviedb.org/3/"
private val mediaType = "application/json".toMediaType()

object ServiceProvider {

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json.asConverterFactory(mediaType))
        .build()

    val service = retrofit.create(MovieApi::class.java)
}