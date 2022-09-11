package com.example.collegeapp.features.article.data

interface ArticleRepository {
    fun getArticle(): List<ArticleEntity>
}