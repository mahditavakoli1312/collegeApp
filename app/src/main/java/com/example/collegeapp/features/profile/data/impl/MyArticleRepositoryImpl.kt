package com.example.collegeapp.features.profile.data.impl

import com.example.collegeapp.features.article.data.ArticleDataSource
import com.example.collegeapp.features.profile.data.MyArticleRepository
import com.example.collegeapp.features.search.data.entities.MyArticleEntity
import javax.inject.Inject

class MyArticleRepositoryImpl @Inject constructor(
    private val articleDataSource: ArticleDataSource
) : MyArticleRepository {
    override fun getArticle(): List<MyArticleEntity> {
        return articleDataSource.getMyArticle()
    }
}