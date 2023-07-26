package app.aihunt.movie.data

import app.aihunt.movie.common.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

object SafeApiRequest {

    suspend fun <T> apiRequest(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> Response<T>
    ): Flow<ApiResult<T>> = flow {
        emit(ApiResult.Loading)
        val response = apiCall()
        if (response.isSuccessful && response.body() != null) {
            emit(ApiResult.Success(response.body()!!))
        } else {
            emit(ApiResult.Error(Exception(response.errorBody()?.string())))
        }
    }.catch { e ->
        emit(ApiResult.Error(e))
    }.flowOn(dispatcher)
}