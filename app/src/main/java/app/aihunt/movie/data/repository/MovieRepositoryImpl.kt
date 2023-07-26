package app.aihunt.movie.data.repository

import app.aihunt.movie.common.ApiResult
import app.aihunt.movie.data.SafeApiRequest
import app.aihunt.movie.data.model.MovieListResponse
import app.aihunt.movie.data.remote.ApiService
import app.aihunt.movie.domain.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getMovies(): Flow<ApiResult<MovieListResponse>> =
        SafeApiRequest.apiRequest {
            apiService.getMovies()
        }
}