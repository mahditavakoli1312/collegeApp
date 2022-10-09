package com.example.collegeapp.features.article.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.profile.data.model.entity.UserArticleTagEntity

@Dao
interface UserArticleTagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserArticleTag(userArticletags: List<UserArticleTagEntity>)

    @Query("SELECT * FROM user_article_tag")
    suspend fun getUserArticleTag(): List<UserArticleTagEntity>
}