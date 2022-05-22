package com.gfdellatin.pirateflix.domain.model.use_case

import com.gfdellatin.pirateflix.data.DiscoveryRepository
import com.gfdellatin.pirateflix.domain.model.Movies
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: DiscoveryRepository
) {
    suspend operator fun invoke() : Result<List<Movies>> {
        return try {
            Result.success(repository.getMovies())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}