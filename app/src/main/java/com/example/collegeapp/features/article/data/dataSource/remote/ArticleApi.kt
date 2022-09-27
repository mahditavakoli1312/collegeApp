package com.example.collegeapp.features.article.data.datasource.remote

import com.example.collegeapp.features.article.data.model.ArticleBaseResponse
import com.example.collegeapp.features.article.data.model.TagBaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {
    @GET("articles")
    suspend fun getSingleArticle(@Query("id") id: Int): Response<ArticleBaseResponse>

    @GET("articles")
    suspend fun getArticles() : Response<ArticleBaseResponse>

    @GET("tags")
    suspend fun getTags() : Response<TagBaseResponse>

}