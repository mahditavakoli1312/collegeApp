package com.example.collegeapp.features.article.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity

@Dao
interface UserArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserArticle(userArticles: List<UserArticleDataEntity>)

    @Query("SELECT * FROM user_article WHERE authorId = :authorId")
    suspend fun getUserArticles(authorId: Int): List<UserArticleDataEntity>
}
