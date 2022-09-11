package com.example.collegeapp.features.bookmark.data

import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val bookmarkDataResource: BookmarkDataResource
) : BookmarkRepository {
    override fun getBookmark() = bookmarkDataResource.getBookmark()
}