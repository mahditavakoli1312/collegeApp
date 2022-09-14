package com.example.collegeapp.features.article.data

import androidx.annotation.DrawableRes

data class ArticleEntity(
    val id: Int = -1,
    val title: String = "",
    @DrawableRes
    val image: Int = 0,
    val time: String = "",
    val writer: String = "",
    val tag: String = ""
)
