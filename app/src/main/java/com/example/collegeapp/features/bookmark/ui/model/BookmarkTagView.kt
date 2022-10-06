package com.example.collegeapp.features.bookmark.ui.model

import com.example.collegeapp.features.article.data.model.entity.TagEntity

data class BookmarkTagView(
    val id: Int,
    val title: String
)


fun TagEntity.toBookmarkTagView() = BookmarkTagView(
    id = id,
    title = name
)
