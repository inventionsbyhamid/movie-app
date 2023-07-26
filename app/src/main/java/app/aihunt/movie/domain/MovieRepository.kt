package app.aihunt.movie.domain

import app.aihunt.movie.common.ApiResult
import app.aihunt.movie.data.model.MovieListResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies(): Flow<ApiResult<MovieListResponse>>
}