package com.example.collegeapp.features.article.ui.model

import com.example.collegeapp.features.article.data.model.ArticleTagResponse
import com.example.collegeapp.features.article.data.model.TagEntity

data class TagView(
    val id: Int,
    val title: String
)


fun TagEntity.toTagView() = TagView(
    id = id,
    title = name
)
