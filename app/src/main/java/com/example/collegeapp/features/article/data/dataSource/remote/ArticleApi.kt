package com.example.collegeapp.features.article.data.dataSource.remote

import com.example.collegeapp.features.article.data.model.ArticleBaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {
    @GET("articles")
    suspend fun getSingleArticle(@Query("id") id: Int): Response<ArticleBaseResponse>
}