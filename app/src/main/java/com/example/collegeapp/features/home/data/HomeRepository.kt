package com.example.collegeapp.features.home.data

import com.example.collegeapp.features.article.data.ArticleEntity

interface HomeRepository {
    fun getHomeTags(): List<String>
    fun getArticleWithTag(tags: List<String>): List<ArticleEntity>
}