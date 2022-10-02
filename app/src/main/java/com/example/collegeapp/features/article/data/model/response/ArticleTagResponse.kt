package com.example.collegeapp.features.article.data.model.response

import com.google.gson.annotations.SerializedName


data class ArticleTagResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null
)