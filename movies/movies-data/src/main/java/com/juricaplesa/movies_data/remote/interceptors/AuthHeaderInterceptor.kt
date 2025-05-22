package com.juricaplesa.movies_data.remote.interceptors

import com.juricaplesa.core_data.ApiKeyProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthHeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer ${ApiKeyProvider.accessToken}")
                .build()

        return chain.proceed(request)
    }
}