package com.example.collegeapp.features.search.data.entities

import androidx.annotation.DrawableRes

data class MyArticleEntity(
    val title: String,
    @DrawableRes
    val image: Int,
    val time: String,
    val writer: String,
    val tag: String,
    val inProgress: Boolean
)
