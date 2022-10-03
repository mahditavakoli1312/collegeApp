package com.example.collegeapp.features.article.data.model.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.collegeapp.features.bookmark.ui.model.BookmarkView

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

fun BookmarkView.toBookmarkEntity() =
    BookmarkEntity(
        serverId = serverId
    )