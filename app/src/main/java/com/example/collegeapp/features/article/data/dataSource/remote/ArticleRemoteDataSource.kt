package com.example.collegeapp.features.article.data.dataSource.remote

import com.example.collegeapp.features.article.data.model.ArticleBaseResponse

interface ArticleRemoteDataSource {
    suspend fun getSingleArticle(id: Int): ArticleBaseResponse?
}