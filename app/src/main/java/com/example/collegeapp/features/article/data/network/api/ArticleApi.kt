package com.example.collegeapp.features.article.data.network.api

import com.example.collegeapp.features.article.data.model.response.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ArticleApi {

    //TODO : send Authorization and accessToken
    @GET("articles")
    suspend fun getArticleDetails(@Query("id") id: Int): Response<ArticleDetailBaseResponse>
    @GET("articles")
    suspend fun getArticles(): Response<ArticleBaseResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagBaseResponse>

    @POST("articles")
    suspend fun addArticle(@Body addArticleRequest: AddArticleRequest) : Response<AddArticleResponse>

}