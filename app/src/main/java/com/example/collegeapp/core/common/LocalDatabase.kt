package com.example.collegeapp.core.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.collegeapp.features.article.data.db.dao.*
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleTagEntity

@Database(
    entities = [
        ArticleEntity::class,
        TagEntity::class,
        ArticleDetailsEntity::class,
        BookmarkEntity::class,
        UserArticleTagEntity::class,
        UserArticleDataEntity::class
    ], version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
    abstract fun getTagDao(): TagDao
    abstract fun getArticleDetailsDao(): ArticleDetailsDao
    abstract fun getBookmarkDao(): BookmarkDao
    abstract fun getUserArticleDataDao(): UserArticleDao
    abstract fun getUserArticleTagDao(): UserArticleTagDao

}