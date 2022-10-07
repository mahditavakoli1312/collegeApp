package com.example.collegeapp.features.article.data.model.response

import com.google.gson.annotations.SerializedName

data class AddArticleResponse(
    @SerializedName("article_id")
    val articleId: Int,
    val message: String
)
