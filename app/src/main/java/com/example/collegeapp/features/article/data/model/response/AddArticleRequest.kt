package com.example.collegeapp.features.article.data.model.response

import com.example.collegeapp.features.article.ui.model.AddArticleView

data class AddArticleRequest(
    val title: String,
    val content: String,
    val tags: String
)

fun AddArticleView.toAddArticleRequest() = AddArticleRequest(
    title = title,
    content = content,
    tags = tag.toString()
)
