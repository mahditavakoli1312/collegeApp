package com.example.collegeapp.features.article.data.dataSource.local

import com.example.collegeapp.features.article.data.dp.dao.*
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleTagEntity
import javax.inject.Inject

class ArticleLocalDataSource @Inject constructor(
    private val articleDao: ArticleDao,
    private val tagDao: TagDao,
    private val articleDetailsDao: ArticleDetailsDao,
    private val bookmarkDao: BookmarkDao,
    private val userArticleDao: UserArticleDao,
    private val userArticleTagDao: UserArticleTagDao
) {
    suspend fun getArticles() = articleDao.getArticles()

    //TODO Change authorId to sharedPref
    fun getMyArticle() = articleDao.getArticleWithAuthorId(1)

    suspend fun getAllTags(): List<TagEntity> = tagDao.getAllTags()

    suspend fun insertTags(tags: List<TagEntity>) = tagDao.insertTags(tags)

    suspend fun getArticleWithId(articleId: Int) =
        articleDao.getArticleWithId(articleId)

    fun insertArticles(articles: List<ArticleEntity>) =
        articleDao.insertArticles(articles)

    fun getArticleDetailsById(id: Int): ArticleDetailsEntity? =
        articleDetailsDao.getArticleDetailsById(id)

    suspend fun insertArticleDetails(article: ArticleDetailsEntity) =
        articleDetailsDao.insertArticleDetails(article = article)

    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) =
        bookmarkDao.insertBookmark(bookmarkEntity = bookmarkEntity)

    suspend fun removeBookmarkByServerId(serverId: Int) =
        bookmarkDao.removeBookmarkByServerId(serverId = serverId)

    suspend fun bookmarksIsExist(serverId: Int): Boolean =
        bookmarkDao.howManyAreExist(serverId = serverId) != 0

    suspend fun insertUserArticle(userArticles: List<UserArticleDataEntity>) =
        userArticleDao.insertUserArticle(userArticles = userArticles)

    suspend fun getUserArticleByAuthorId(authorId: Int): List<UserArticleDataEntity> =
        userArticleDao.getUserArticles(authorId = authorId)

    suspend fun insertUserArticleTag(userArticletags: List<UserArticleTagEntity>) =
        userArticleTagDao.insertUserArticleTag(userArticletags = userArticletags)

    suspend fun getUserArticleTag(): List<UserArticleTagEntity> =
        userArticleTagDao.getUserArticleTag()

    suspend fun deleteAllArticles() =
        articleDao.deleteAllArticles()
}
