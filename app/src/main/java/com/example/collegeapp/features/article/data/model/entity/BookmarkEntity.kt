package com.example.collegeapp.features.article.data.model.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "bookmark",
    indices = [
        Index(value = ["serverId"], unique = true)
    ]
)
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val serverId: Int
)
