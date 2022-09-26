package com.example.collegeapp.features.article.data.model

import com.google.gson.annotations.SerializedName


data class ArticleBaseResponse(
    @SerializedName("data") var data: ArticleDataResponse? = ArticleDataResponse()
)