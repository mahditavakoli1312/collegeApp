package com.example.collegeapp.features.article.data.datasource.remote

import com.example.collegeapp.features.article.data.model.response.*
import com.example.collegeapp.features.profile.data.model.response.UserArticleDataResponse

interface ArticleRemoteDataSource {
    suspend fun getArticleDetails(id: Int): ArticleDetailBaseResponse?
    suspend fun getArticles(): List<ArticleDataResponse>?
    suspend fun getTags(): List<ArticleTagResponse>?
    suspend fun getArticleByAuthorId(id: Int): List<UserArticleDataResponse>?
    suspend fun addArticle(addArticleRequest: AddArticleRequest): AddArticleResponse?
}