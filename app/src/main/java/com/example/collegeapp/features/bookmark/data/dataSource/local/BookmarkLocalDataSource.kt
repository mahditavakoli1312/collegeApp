package com.example.collegeapp.features.bookmark.data.dataSource.local

import com.example.collegeapp.features.article.data.model.entity.ArticleEntity

interface BookmarkLocalDataSource {
    suspend fun getBookmarks(): List<ArticleEntity?>
}