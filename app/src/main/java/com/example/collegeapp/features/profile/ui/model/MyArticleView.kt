package com.example.collegeapp.features.profile.ui.model

import androidx.annotation.DrawableRes

data class MyArticleView(
    val title: String,
    @DrawableRes
    val image: Int,
    val time: String,
    val writer: String,
    val tag: String,
    val inProgress: Boolean
)
