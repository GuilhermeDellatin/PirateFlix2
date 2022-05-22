package com.gfdellatin.pirateflix.data

import com.gfdellatin.pirateflix.BuildConfig
import com.gfdellatin.pirateflix.data.api.DiscoverAPI
import com.gfdellatin.pirateflix.data.model.toDomain
import com.gfdellatin.pirateflix.domain.model.Movies
import javax.inject.Inject

class DiscoveryRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverAPI
) : DiscoveryRepository {

    override suspend fun getMovies(): List<Movies> {
        return  try {
            discoverService.getMovies(BuildConfig.tmdbToken).results.map {
                it.toDomain()
            }
        } catch (exception: Exception) {
            throw DiscoveryRepositoryException()
        }
    }

}

class DiscoveryRepositoryException: Exception()