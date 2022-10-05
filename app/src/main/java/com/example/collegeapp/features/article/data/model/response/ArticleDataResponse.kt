package com.example.collegeapp.features.article.data.model.response

import com.google.gson.annotations.SerializedName

data class ArticleDataResponse(
    val id: Int? = null,
    val title: String? = null,
    val content: String? = null,
    @SerializedName("read_time_minutes") val readTimeMinutes: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("author_id") val authorId: Int? = null,
    @SerializedName("author_first_name") val authorFirstName: String? = null,
    @SerializedName("author_last_name") val authorLastName: String? = null,
    @SerializedName("author_username") val authorUsername: String? = null,
    val tags: ArrayList<ArticleTagResponse> = arrayListOf(),
)