package com.example.collegeapp.core.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.collegeapp.features.article.data.dp.dao.ArticleDao
import com.example.collegeapp.features.article.data.dp.dao.ArticleDetailsDao
import com.example.collegeapp.features.article.data.dp.dao.TagDao
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity

@Database(
    entities = [
        ArticleEntity::class,
        TagEntity::class,
        ArticleDetailsEntity::class
    ], version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
    abstract fun getTagDao(): TagDao
    abstract fun getArticleDetailsDao(): ArticleDetailsDao
}