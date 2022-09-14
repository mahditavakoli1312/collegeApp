package com.example.collegeapp.features.bookmark.data.impl

import com.example.collegeapp.features.bookmark.data.BookmarkDataResource
import com.example.collegeapp.features.bookmark.data.BookmarkRepository
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDataResource: BookmarkDataResource
) : BookmarkRepository {
    override fun getBookmark() = bookmarkDataResource.getBookmark()
}