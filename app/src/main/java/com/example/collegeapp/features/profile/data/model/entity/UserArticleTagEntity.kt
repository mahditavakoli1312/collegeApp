package com.example.collegeapp.features.profile.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.collegeapp.features.profile.data.model.response.UserArticleTagResponse

@Entity(tableName = "user_article_tag")
data class UserArticleTagEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_article_tag_id")
    val id: Int = -1,
    val name: String? = null
)

fun UserArticleTagResponse.toUserArticleTagEntity() =
    UserArticleTagEntity(
        id = id ?: -1,
        name = name
    )