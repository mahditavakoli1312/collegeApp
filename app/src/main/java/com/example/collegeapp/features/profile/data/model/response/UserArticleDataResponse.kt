package com.example.collegeapp.features.profile.data.model.response

import com.google.gson.annotations.SerializedName

data class UserArticleDataResponse(
    val id: Int? = null,
    val title: String? = null,
    val content: String? = null,
    @SerializedName("author_id") val authorId: Int? = null,
    @SerializedName("read_time_minutes") val readTimeMinutes: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    val tags: List<UserArticleTagResponse> = listOf(),
    @SerializedName("comments_count") val commentsCount: String? = null
)