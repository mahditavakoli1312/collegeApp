package com.example.collegeapp.features.search.data.dataSource.local

import com.example.collegeapp.features.article.data.model.entity.ArticleEntity

interface SearchLocalDataSource {
    fun getPosts(): List<ArticleEntity>
    fun getTags(): List<String>
}