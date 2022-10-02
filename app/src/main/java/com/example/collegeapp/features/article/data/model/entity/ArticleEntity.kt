package com.example.collegeapp.features.article.data.model.entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.collegeapp.R
import com.example.collegeapp.features.article.data.model.response.ArticleDataResponse

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    val title: String = "",
    val content: String,
    @DrawableRes
    val image: Int = 0,
    @ColumnInfo(name = "created_at")
    val createdTime: String = "",
    @ColumnInfo(name = "author_id")
    val authorId: Int,
    @ColumnInfo(name = "author_first_name")
    val authorFirstName: String,
    @ColumnInfo(name = "author_last_name")
    val authorLastName: String,
    @ColumnInfo(name = "author_username")
    val authorUsername: String,
    @Embedded
    val tag: TagEntity,
    val isBookmark: Boolean
)

fun ArticleDataResponse.toArticleEntity() = ArticleEntity(
    id = id ?: -1,
    title = title ?: "",
    content = content ?: "",
    image = R.drawable.background_image,
    createdTime = createdAt ?: "",
    authorId = authorId ?: -1,
    authorFirstName = authorFirstName ?: "",
    authorLastName = authorLastName ?: "",
    authorUsername = authorUsername ?: "",
    tag = TagEntity(tags[0].id ?: -1, tags[0].name ?: ""),
    isBookmark = false
)

