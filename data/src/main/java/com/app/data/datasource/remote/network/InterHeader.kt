package com.app.data.datasource.remote.network

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class InterHeader() : Interceptor {
    private lateinit var request: Request
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .method(originalRequest.method, originalRequest.body)
            .header("Content-Type", "application/json")
        runBlocking {
                requestBuilder.header(
                    "X-API-Key",
                   "bffcc943fd564b9bad18c0dec54ae4f9"
                )
        }
        request = requestBuilder.build()
      return chain.proceed(request)
    }
}