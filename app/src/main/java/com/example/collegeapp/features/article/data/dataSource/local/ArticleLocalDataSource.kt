package com.example.collegeapp.features.article.data.dataSource.local

import com.example.collegeapp.core.common.LocalDatabase
import com.example.collegeapp.features.article.data.dp.dao.ArticleDetailsDao
import com.example.collegeapp.features.article.data.dp.dao.BookmarkDao
import com.example.collegeapp.features.article.data.model.entity.ArticleDetailsEntity
import com.example.collegeapp.features.article.data.model.entity.ArticleEntity
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.article.data.model.entity.TagEntity
import javax.inject.Inject

class ArticleLocalDataSource @Inject constructor(
    // TODO Sobhan BazuBandi : delete database access from datasource
    private val localDatabase: LocalDatabase,
    private val articleDao: ArticleDetailsDao,
    private val bookmarkDao: BookmarkDao
) {

    suspend fun getArticles() = localDatabase.getArticleDao().getArticles()

    //TODO Change authorId to sharedPref
    fun getMyArticle() = localDatabase.getArticleDao().getArticleWithAuthorId(1)

    suspend fun getAllTags(): List<TagEntity> = localDatabase.getTagDao().getAllTags()

    suspend fun insertTags(tags: List<TagEntity>) = localDatabase.getTagDao().insertTags(tags)


    suspend fun getArticleWithId(articleId: Int) =
        localDatabase.getArticleDao().getArticleWithId(articleId)

    fun insertArticles(articles: List<ArticleEntity>) =
        localDatabase.getArticleDao().insertArticles(articles)

    fun getArticleDetailsById(id: Int): ArticleDetailsEntity? =
        articleDao.getArticleDetailsById(id)

    suspend fun insertArticleDetails(article: ArticleDetailsEntity) =
        articleDao.insertArticleDetails(article = article)

    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) =
        bookmarkDao.insertBookmark(bookmarkEntity = bookmarkEntity)

    suspend fun removeBookmarkByServerId(serverId: Int) =
        bookmarkDao.removeBookmarkByServerId(serverId = serverId)

    suspend fun bookmarksIsExist(serverId: Int): Boolean =
        bookmarkDao.howManyAreExist(serverId = serverId) != 0


}
