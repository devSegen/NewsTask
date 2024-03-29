package com.app.data.datasource.remote.network

import com.app.data.models.news.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

  @GET("everything")
  suspend fun getNews(@Query("q") searchKey: String? = null): Response<NewsListResponse>

}