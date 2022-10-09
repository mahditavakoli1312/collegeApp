package com.example.collegeapp.features.article.data.datasource.local.impl

import com.example.collegeapp.features.article.data.datasource.local.ArticleLocalDataSource
import com.example.collegeapp.features.article.data.db.dao.*
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity
import com.example.collegeapp.features.profile.data.model.entity.UserArticleTagEntity
import javax.inject.Inject

class ArticleLocalDataSourceImpl @Inject constructor(
    private val articleDao: ArticleDao,
    private val tagDao: TagDao,
    private val articleDetailsDao: ArticleDetailsDao,
    private val bookmarkDao: BookmarkDao,
    private val userArticleDao: UserArticleDao,
    private val userArticleTagDao: UserArticleTagDao
) : ArticleLocalDataSource {
    override suspend fun getArticles() = articleDao.getArticles()

    override suspend fun getAllTags(): List<TagEntity> = tagDao.getAllTags()

    override suspend fun insertTags(tags: List<TagEntity>) = tagDao.insertTags(tags)

    override suspend fun getArticleWithId(articleId: Int) =
        articleDao.getArticleWithId(articleId)

    override fun insertArticles(articles: List<ArticleEntity>) =
        articleDao.insertArticles(articles)

    override fun getArticleDetailsById(id: Int): ArticleDetailsEntity? =
        articleDetailsDao.getArticleDetailsById(id)

    override suspend fun insertArticleDetails(article: ArticleDetailsEntity) =
        articleDetailsDao.insertArticleDetails(article = article)

    override suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) =
        bookmarkDao.insertBookmark(bookmarkEntity = bookmarkEntity)

    override suspend fun removeBookmarkByServerId(serverId: Int) =
        bookmarkDao.removeBookmarkByServerId(serverId = serverId)

    override suspend fun bookmarksIsExist(serverId: Int): Boolean =
        bookmarkDao.howManyAreExist(serverId = serverId) != 0

    override suspend fun getTagSelected(): List<TagEntity>? = tagDao.getTagSelected()

    override suspend fun getTagChecked(): List<TagEntity>? = tagDao.getTagChecked()

    override suspend fun updateTag(tag: TagEntity) = tagDao.updateTag(tag)

    override suspend fun updateTags(tags: List<TagEntity>) = tagDao.updateTags(tags)

    override suspend fun deleteAllArticles() =
        articleDao.deleteAllArticles()

    override suspend fun insertUserArticle(userArticles: List<UserArticleDataEntity>) =
        userArticleDao.insertUserArticle(userArticles = userArticles)

    override suspend fun getUserArticleByAuthorId(authorId: Int): List<UserArticleDataEntity> =
        userArticleDao.getUserArticles(authorId = authorId)

    override suspend fun insertUserArticleTag(userArticletags: List<UserArticleTagEntity>) =
        userArticleTagDao.insertUserArticleTag(userArticletags = userArticletags)

    override suspend fun getUserArticleTag(): List<UserArticleTagEntity> =
        userArticleTagDao.getUserArticleTag()
}
