package com.example.collegeapp.features.article.data.repository

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView

interface ArticleRepository {

    suspend fun getArticles(): ResultWrapper<List<ArticleView>>
    suspend fun getTags(): ResultWrapper<List<TagView>>
    suspend fun getArticleWithTags(tags: List<TagView>): List<ArticleView>
    suspend fun getArticleWithId(articleID: Int): ArticleView?
    suspend fun getArticleDetails(id: Int): ResultWrapper<ArticleView>

}