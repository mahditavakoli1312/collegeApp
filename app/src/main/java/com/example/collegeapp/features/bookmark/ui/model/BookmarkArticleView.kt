package com.example.collegeapp.features.bookmark.ui.model

import androidx.annotation.DrawableRes
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity

data class BookmarkArticleView(
    val id: Int,
    val title: String,
    val content: String,
    @DrawableRes
    val image: Int,
    val createdTime: String,
    val author: String,
    val tag: BookmarkTagView
)

fun ArticleEntity.toBookmarkArticleView() = BookmarkArticleView(
    id = id,
    title = title,
    content = content,
    image = image,
    createdTime = createdTime,
    author = "$authorFirstName $authorLastName",
    tag = tag.toBookmarkTagView()
)

