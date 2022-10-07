package com.example.collegeapp.features.article.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.collegeapp.features.article.data.model.response.ArticleTagResponse
import com.example.collegeapp.features.article.ui.model.TagView

@Entity(tableName = "tags")
data class TagEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id")
    val id: Int,
    val name: String,
    //for show view
    val isSelected: Int = 0,
    //for choose filter article
    val isChecked: Int = 0
)

fun ArticleTagResponse.toTagEntity() = TagEntity(
    id = id ?: -1,
    name = name ?: "",
)

fun TagView.toTagEntity() = TagEntity(
    id = id,
    name = title,
    isChecked = isChecked,
    isSelected = isSelected
)
