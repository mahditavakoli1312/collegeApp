package com.example.collegeapp.features.article.data.datasource.local.impl

import com.example.collegeapp.features.article.data.datasource.local.ArticleLocalDataSource
import com.example.collegeapp.features.article.data.dp.dao.ArticleDao
import com.example.collegeapp.features.article.data.dp.dao.ArticleDetailsDao
import com.example.collegeapp.features.article.data.dp.dao.BookmarkDao
import com.example.collegeapp.features.article.data.dp.dao.TagDao
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import javax.inject.Inject

class ArticleLocalDataSourceImpl @Inject constructor(
    private val articleDao: ArticleDao,
    private val tagDao: TagDao,
    private val articleDetailsDao: ArticleDetailsDao,
    private val bookmarkDao: BookmarkDao
) : ArticleLocalDataSource{
    override suspend fun getArticles() = articleDao.getArticles()

    //TODO Change authorId to sharedPref
    override fun getMyArticle() = articleDao.getArticleWithAuthorId(1)

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

    override suspend fun getTagSelected() : List<TagEntity>? = tagDao.getTagSelected()

    override suspend fun getTagChecked() :  List<TagEntity>? = tagDao.getTagChecked()

    override suspend fun updateTag(tag : TagEntity) = tagDao.updateTag(tag)

    override suspend fun updateTags(tags : List<TagEntity>) = tagDao.updateTags(tags)

}
