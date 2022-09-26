package com.example.collegeapp.features.article.data

import com.example.collegeapp.core.networkUtils.ResultWrapper

interface ArticleRepository {
    fun getArticle(): List<ArticleEntity>
    suspend fun getSingleArticleRemote(id: Int): ResultWrapper<ArticleEntity?>
}