package com.example.collegeapp.features.bookmark.data.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity

data class BookmarkWithArticle(
    @Embedded val bookmark: BookmarkEntity,
    @Relation(
        parentColumn = "serverId",
        entityColumn = "id"
    ) val article: ArticleEntity?
)