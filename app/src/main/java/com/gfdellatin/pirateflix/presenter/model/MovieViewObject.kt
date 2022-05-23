package com.gfdellatin.pirateflix.presenter.model

import com.gfdellatin.pirateflix.domain.model.Movies

data class MovieViewObject(
    val name: String,
    val poster: String
) {
    constructor(movies: Movies) : this(
        name = movies.title,
        poster = movies.posterPath
    )
}