package com.example.collegeapp.features.article.data

import androidx.annotation.DrawableRes
import com.example.collegeapp.features.article.data.model.ArticleDataResponse

data class ArticleEntity(
    val id: Int = -1,
    val title: String = "",
    @DrawableRes
    val image: Int = 0,
    val time: String = "",
    val writer: String = "",
    val tag: String = ""
)

// TODO : change toArticleEntity method
fun ArticleDataResponse.toArticleEntity() = ArticleEntity(
    id = id ?: 0,
    title = "vdfvkjsdfvhkxfkhb",
    image = 0,
    time = "erere",
    writer = "",
    tag = ""
)

