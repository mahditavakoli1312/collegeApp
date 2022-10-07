package com.example.collegeapp.features.article.ui.model

import com.example.collegeapp.features.article.data.model.entity.TagEntity

data class TagView(
    val id: Int,
    val title: String,
    var isChecked: Int = 0,
    var isSelected: Int = 0
)


fun TagEntity.toTagView() = TagView(
    id = id,
    title = name,
    isChecked = isChecked,
    isSelected = isSelected
)

