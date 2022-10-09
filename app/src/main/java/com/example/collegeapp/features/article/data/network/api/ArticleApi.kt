package com.example.collegeapp.features.article.data.network.api

import com.example.collegeapp.features.article.data.model.response.*
import com.example.collegeapp.features.profile.data.model.response.UserArticleBaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ArticleApi {


    @GET("articles")
    suspend fun getArticleDetails(@Query("id") id: Int): Response<ArticleDetailBaseResponse>

    @GET("articles")
    suspend fun getArticles(): Response<ArticleBaseResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagBaseResponse>

    @GET("articles")
    suspend fun getArticleByAuthorId(@Query("author_id") authorId: Int): Response<UserArticleBaseResponse>

    @POST("articles")
    suspend fun addArticle(@Body addArticleRequest: AddArticleRequest): Response<AddArticleResponse>
}