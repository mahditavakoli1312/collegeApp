package com.example.collegeapp.features.article.data.datasource.local

import com.example.collegeapp.core.common.LocalDatabase
import com.example.collegeapp.features.article.data.model.ArticleEntity
import com.example.collegeapp.features.article.data.model.TagEntity
import javax.inject.Inject

class ArticleLocalDataSource @Inject constructor(
    private val localDatabase: LocalDatabase
) {

    fun getArticles() = localDatabase.getArticleDao().getArticles()

    //TODO Change authorId to sharedPref
    fun getMyArticle() = localDatabase.getArticleDao().getArticleWithAuthorId(1)

    fun getAllTags() = localDatabase.getTagDao().getAllTags()

    fun addTags(tags : List<TagEntity>) = localDatabase.getTagDao().insertTags(tags)

    suspend fun getArticleWithId(articleId : Int) = localDatabase.getArticleDao().getArticleWithId(articleId)

    fun addArticles(articles: List<ArticleEntity>) = localDatabase.getArticleDao().insertArticles(articles)

}