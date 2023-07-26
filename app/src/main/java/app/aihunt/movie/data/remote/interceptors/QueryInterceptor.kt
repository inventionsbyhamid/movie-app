package app.aihunt.movie.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import app.aihunt.movie.BuildConfig


class QueryInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()
        return chain.proceed(request.newBuilder().url(url).build())
    }
}