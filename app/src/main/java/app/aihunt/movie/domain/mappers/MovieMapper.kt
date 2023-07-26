package app.aihunt.movie.domain.mappers

import app.aihunt.movie.data.model.MovieResponse
import app.aihunt.movie.domain.model.Movie

fun MovieResponse.toMovie(): Movie =
    Movie(
        imageUrl = imageUrl,
        id = id,
        title = title,
        description = description
    )


