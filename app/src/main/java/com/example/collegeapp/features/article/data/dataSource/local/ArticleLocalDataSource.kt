package com.example.collegeapp.features.article.data.datasource.local

import androidx.lifecycle.LiveData
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleTagEntity

interface ArticleLocalDataSource {
    suspend fun getArticles(): List<ArticleEntity>
    suspend fun getAllTags(): List<TagEntity>
    suspend fun insertTags(tags: List<TagEntity>): List<Long>
    suspend fun getArticleWithId(articleId: Int): ArticleEntity
    fun insertArticles(articles: List<ArticleEntity>)
    fun getArticleDetailsById(id: Int): ArticleDetailsEntity?
    suspend fun insertArticleDetails(article: ArticleDetailsEntity)
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)
    suspend fun removeBookmarkByServerId(serverId: Int)
    suspend fun bookmarksIsExist(serverId: Int): Boolean
    suspend fun getTagSelected(): List<TagEntity>?
    suspend fun getTagChecked(): List<TagEntity>?
    suspend fun updateTag(tag: TagEntity)
    suspend fun updateTags(tags: List<TagEntity>)
    suspend fun deleteAllArticles()
    suspend fun insertUserArticle(userArticles: List<UserArticleDataEntity>)
    suspend fun getUserArticleByAuthorId(authorId: Int): List<UserArticleDataEntity>
    suspend fun insertUserArticleTag(userArticletags: List<UserArticleTagEntity>)
    suspend fun getUserArticleTag(): List<UserArticleTagEntity>

}