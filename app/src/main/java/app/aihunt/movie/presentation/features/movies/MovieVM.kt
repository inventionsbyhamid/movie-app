package app.aihunt.movie.presentation.features.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.aihunt.movie.R
import app.aihunt.movie.common.ApiResult
import app.aihunt.movie.domain.MovieRepository
import app.aihunt.movie.domain.mappers.toMovie
import app.aihunt.movie.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieVM @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviesUiState(loading = true))
    val uiState: StateFlow<MoviesUiState> = _uiState

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            movieRepository.getMovies().collect { response ->
                when (response) {
                    is ApiResult.Error -> _uiState.update {
                        it.copy(loading = false, error = R.string.error_loading_movies)
                    }

                    is ApiResult.Loading -> _uiState.update {
                        it.copy(loading = true)
                    }

                    is ApiResult.Success -> {
                        val movies = response.data.results.map { it.toMovie() }
                        _uiState.update {
                            it.copy(
                                movies = movies,
                                loading = false,
                                error = null
                            )
                        }
                    }
                }
            }
        }
    }

    fun onMovieClick(movie: Movie) {
        _uiState.update {
            it.copy(selectedMovie = movie)
        }
    }

}