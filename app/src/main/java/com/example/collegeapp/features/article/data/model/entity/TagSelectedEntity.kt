package com.example.collegeapp.features.article.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag_selected")
data class TagSelectedEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    //for show in view
    val isSelected: Int = 0,
    //for show article with this tag
    val isCheck: Int = 0
)

