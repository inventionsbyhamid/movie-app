package app.aihunt.movie.presentation.features.movies

import androidx.annotation.StringRes
import app.aihunt.movie.domain.model.Movie

data class MoviesUiState(
    val movies: List<Movie> = emptyList(),
    val loading: Boolean = false,
    @StringRes val error: Int? = null,
    val selectedMovie: Movie? = null
)