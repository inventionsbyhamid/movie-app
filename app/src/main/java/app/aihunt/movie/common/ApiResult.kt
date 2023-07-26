package app.aihunt.movie.common

sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error(val exception: Throwable? = null) : ApiResult<Nothing>
    object Loading : ApiResult<Nothing>
}