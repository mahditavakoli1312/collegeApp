package com.example.collegeapp.features.article.data.dataSource.local

import com.example.collegeapp.features.article.data.dp.dao.ArticleDao
import com.example.collegeapp.features.article.data.dp.dao.ArticleDetailsDao
import com.example.collegeapp.features.article.data.dp.dao.BookmarkDao
import com.example.collegeapp.features.article.data.dp.dao.TagDao
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import javax.inject.Inject

class ArticleLocalDataSource @Inject constructor(
    private val articleDao: ArticleDao,
    private val tagDao: TagDao,
    private val articleDetailsDao: ArticleDetailsDao,
    private val bookmarkDao: BookmarkDao
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

}
