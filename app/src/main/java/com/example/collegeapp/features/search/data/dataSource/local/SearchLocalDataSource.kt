package com.example.collegeapp.features.search.data.dataSource.local

import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.search.ui.model.SearchUserView

interface SearchLocalDataSource {
    fun getPosts(): List<ArticleEntity>
    fun getUsers(): List<SearchUserView>
    fun getTags(): List<String>
}