package com.example.collegeapp.features.profile.ui.model

import com.example.collegeapp.features.profile.data.model.entity.UserArticleTagEntity

data class UserArticleTagView(
    val id: Int? = null,
    val name: String? = null
)

fun UserArticleTagEntity.toUserArticleTagView() =
    UserArticleTagView(
        id = id,
        name = name
    )
