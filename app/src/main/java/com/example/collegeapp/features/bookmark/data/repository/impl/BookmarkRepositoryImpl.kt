package com.example.collegeapp.features.bookmark.data.repository.impl

import com.example.collegeapp.features.bookmark.data.dataSource.local.BookmarkLocalDataSource
import com.example.collegeapp.features.bookmark.data.repository.BookmarkRepository
import com.example.collegeapp.features.bookmark.ui.model.toBookmarkArticleView
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkLocalDataSourceImpl: BookmarkLocalDataSource
) : BookmarkRepository {
    override suspend fun getBookmarks() =
        bookmarkLocalDataSourceImpl.getBookmarks().map { articleEntity ->
            articleEntity?.toBookmarkArticleView()
        }
}