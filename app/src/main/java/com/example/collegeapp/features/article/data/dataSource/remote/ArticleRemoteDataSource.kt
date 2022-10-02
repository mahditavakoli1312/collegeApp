package com.example.collegeapp.features.article.data.datasource.remote

import com.example.collegeapp.features.article.data.model.response.ArticleDataResponse
import com.example.collegeapp.features.article.data.model.response.ArticleDetailBaseResponse
import com.example.collegeapp.features.article.data.model.response.ArticleTagResponse

interface ArticleRemoteDataSource {
    suspend fun getArticleDetails(id: Int): ArticleDetailBaseResponse?
    suspend fun getArticles(): List<ArticleDataResponse>?
    suspend fun getTags(): List<ArticleTagResponse>?
}