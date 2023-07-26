package app.aihunt.movie.data.remote

import app.aihunt.movie.data.model.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(): Response<MovieListResponse>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}