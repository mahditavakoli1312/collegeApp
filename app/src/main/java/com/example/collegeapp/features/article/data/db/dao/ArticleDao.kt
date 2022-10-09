package com.example.collegeapp.features.article.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles")
    suspend fun getArticles(): List<ArticleEntity>

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()

    @Query("SELECT * FROM articles WHERE id = :articleId")
    suspend fun getArticleWithId(articleId: Int): ArticleEntity

    @Query("SELECT * FROM articles WHERE tag_id IN (:tags)")
    fun getArticleWithTags(tags: List<Int>): LiveData<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE author_id = :authorId")
    fun getArticleWithAuthorId(authorId: Int): LiveData<List<ArticleEntity>>
}