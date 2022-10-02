package com.example.collegeapp.features.article.data.model.entity

import androidx.room.Entity

@Entity(
    tableName = "bookmark",
    primaryKeys = ["id", "serverId"],
)
data class BookmarkEntity(
    val id: Int = 0,
    val serverId: Int
)
