package com.gfdellatin.pirateflix.data

import com.gfdellatin.pirateflix.domain.model.Movies

interface DiscoveryRepository {

    suspend fun getMovies() : List<Movies>
}