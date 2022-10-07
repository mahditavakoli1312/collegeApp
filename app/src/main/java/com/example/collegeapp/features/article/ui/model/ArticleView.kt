package com.example.collegeapp.features.article.ui.model

import androidx.annotation.DrawableRes
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity

data class ArticleView(
    val id: Int,
    val title: String,
    val content: String,
    @DrawableRes
    val image: Int,
    //2022-10-07T08:31:02.630Z
    val createdTime: String,
    val author: String,
    val tag: TagView
)

fun ArticleEntity.toArticleView() = ArticleView(
    id = id,
    title = title,
    content = content,
    image = image,
    createdTime = createdTime,
    author = "$authorFirstName $authorLastName",
    tag = tag.toTagView()
)

fun ArticleDetailsEntity.toArticleView() = ArticleView(
    id = id,
    title = title,
    content = content,
    image = image,
    createdTime = createdTime,
    author = "$authorFirstName $authorLastName",
    tag = tag.toTagView()
)
