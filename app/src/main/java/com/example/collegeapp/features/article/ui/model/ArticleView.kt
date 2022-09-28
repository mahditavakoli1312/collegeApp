package com.example.collegeapp.features.article.ui.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.collegeapp.features.article.data.model.ArticleEntity

data class ArticleView(
    val id: Int ,
    val title: String ,
    val content: String,
    @DrawableRes
    val image: Int ,
    val createdTime: String ,
    val author : String ,
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