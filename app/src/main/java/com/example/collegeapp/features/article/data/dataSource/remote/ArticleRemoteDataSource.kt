package com.example.collegeapp.features.article.data.dataSource.remote

import com.example.collegeapp.features.article.data.model.response.*

interface ArticleRemoteDataSource {
    suspend fun getArticleDetails(id: Int): ArticleDetailBaseResponse?
    suspend fun getArticles(): List<ArticleDataResponse>?
    suspend fun getTags(): List<ArticleTagResponse>?
    suspend fun addArticle(addArticleRequest: AddArticleRequest): AddArticleResponse?
}