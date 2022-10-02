package com.example.collegeapp.features.bookmark.data

import com.example.collegeapp.features.article.data.model.entity.ArticleEntity

interface BookmarkRepository {
    fun getBookmark(): List<ArticleEntity>
}