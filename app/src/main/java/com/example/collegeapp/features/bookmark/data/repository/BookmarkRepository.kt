package com.example.collegeapp.features.bookmark.data.repository

import com.example.collegeapp.features.bookmark.ui.model.BookmarkArticleView

interface BookmarkRepository {
    suspend fun getBookmarks(): List<BookmarkArticleView?>
}