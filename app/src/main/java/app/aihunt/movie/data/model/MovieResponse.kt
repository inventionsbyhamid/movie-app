package app.aihunt.movie.data.model

import app.aihunt.movie.data.remote.ApiService
import com.squareup.moshi.Json

data class MovieResponse(
    @Json(name = "backdrop_path") val imagePath: String,
    @Json(name = "id") val id: Long,
    @Json(name = "original_title") val title: String,
    @Json(name = "overview") val description: String,
) {
    val imageUrl: String
        get() = ApiService.IMAGE_BASE_URL + imagePath
}
