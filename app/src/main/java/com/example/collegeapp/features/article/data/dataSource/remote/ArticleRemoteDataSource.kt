package com.example.collegeapp.features.article.data.datasource.remote

import com.example.collegeapp.features.article.data.model.ArticleBaseResponse
import com.example.collegeapp.features.article.data.model.ArticleDataResponse
import com.example.collegeapp.features.article.data.model.ArticleTagResponse
import com.example.collegeapp.features.article.data.model.TagBaseResponse

interface ArticleRemoteDataSource {
    suspend fun getSingleArticle(id: Int): ArticleBaseResponse?
    suspend fun getArticles() : List<ArticleDataResponse>?
    suspend fun getTags() : List<ArticleTagResponse>?
}