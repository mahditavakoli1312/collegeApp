package com.example.collegeapp.features.profile.data.model.entity

import androidx.annotation.DrawableRes
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.collegeapp.R
import com.example.collegeapp.features.profile.data.model.response.UserArticleDataResponse
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_article")
data class UserArticleDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = -1,
    val title: String? = null,
    val content: String? = null,
    @DrawableRes
    val image: Int = 0,
    @SerializedName("author_id") val authorId: Int? = null,
    @SerializedName("read_time_minutes") val readTimeMinutes: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @Embedded
    val tag: UserArticleTagEntity? = null,
    @SerializedName("comments_count") val commentsCount: String? = null
)

fun UserArticleDataResponse.toUserArticleDataEntity() =
    UserArticleDataEntity(
        id = id ?: -1,
        title = title,
        content = content,
        image = R.drawable.background_image,
        authorId = authorId,
        readTimeMinutes = readTimeMinutes,
        createdAt = createdAt,
        tag = tags.first().toUserArticleTagEntity(),
        commentsCount = commentsCount
    )