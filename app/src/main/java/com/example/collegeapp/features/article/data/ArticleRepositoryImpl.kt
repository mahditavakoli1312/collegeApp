package com.example.collegeapp.features.article.data

interface ArticleRepositoryImpl {
    fun getArticle(): List<ArticleEntity>
}