package com.example.collegeapp.features.article.data.model

import com.google.gson.annotations.SerializedName

data class ArticleDataResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("content") var content: String? = null,
    @SerializedName("read_time_minutes") var readTimeMinutes: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("author_id") var authorId: Int? = null,
    @SerializedName("author_first_name") var authorFirstName: String? = null,
    @SerializedName("author_last_name") var authorLastName: String? = null,
    @SerializedName("author_username") var authorUsername: String? = null,
    @SerializedName("tags") var tags: ArrayList<ArticleTagResponse> = arrayListOf(),
)