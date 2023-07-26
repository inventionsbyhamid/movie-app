package app.aihunt.movie.data.model

import com.squareup.moshi.Json

class MovieListResponse(
    @Json(name = "page") val page: Int,
    @Json(name = "results") val results: List<MovieResponse>
) {
}