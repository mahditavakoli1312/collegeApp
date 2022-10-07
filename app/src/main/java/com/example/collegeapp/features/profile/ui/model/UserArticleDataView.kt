package com.example.collegeapp.features.profile.ui.model

import androidx.annotation.DrawableRes
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity
import com.google.gson.annotations.SerializedName

data class UserArticleDataView(
    val id: Int? = null,
    val title: String? = null,
    val content: String? = null,
    @DrawableRes
    val image: Int = 0,
    @SerializedName("author_id") val authorId: Int? = null,
    @SerializedName("read_time_minutes") val readTimeMinutes: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    val tag: UserArticleTagView? = null,
    @SerializedName("comments_count") val commentsCount: String? = null,

    )

fun UserArticleDataEntity.toUserArticleDataView() =
    UserArticleDataView(
        id = id,
        title = title,
        content = content,
        image = image,
        authorId = authorId,
        readTimeMinutes = readTimeMinutes,
        createdAt = createdAt,
        tag = tag?.toUserArticleTagView(),
        commentsCount = commentsCount
    )