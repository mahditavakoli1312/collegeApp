package com.example.collegeapp.features.article.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.collegeapp.features.article.ui.model.TagView

@Entity(tableName = "tags")
data class TagEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tag_id")
    val id : Int ,
    val name : String
)

fun ArticleTagResponse.toTagEntity() = TagEntity(
    id = id ?: -1,
    name = name ?: "",
)
