package com.app.data.models.news

data class NewsListResponse(
  val articles: List<Article>,
  val status: String,
  val totalResults: Int
)