package com.example.collegeapp.features.article.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity

@Dao
interface ArticleDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleDetails(article: ArticleDetailsEntity)

    @Query("SELECT * FROM article_details WHERE id = :id")
    fun getArticleDetailsById(id: Int): ArticleDetailsEntity?
}