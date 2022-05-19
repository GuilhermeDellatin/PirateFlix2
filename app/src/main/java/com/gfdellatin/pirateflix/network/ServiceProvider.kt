package com.gfdellatin.pirateflix.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class ServiceProvider {

    private val baseUrl = "https://api.themoviedb.org/3/"
    private val contentType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    fun <API> createService(apiClass: Class<API>): API = retrofit.create(apiClass)
}