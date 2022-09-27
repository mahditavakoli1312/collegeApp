package com.example.collegeapp.core.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.collegeapp.features.article.data.datasource.local.ArticleDao
import com.example.collegeapp.features.article.data.datasource.local.TagDao
import com.example.collegeapp.features.article.data.model.ArticleEntity
import com.example.collegeapp.features.article.data.model.TagEntity

@Database(
    entities = [
        ArticleEntity::class ,
        TagEntity::class
    ], version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
    abstract fun getTagDao() : TagDao
}