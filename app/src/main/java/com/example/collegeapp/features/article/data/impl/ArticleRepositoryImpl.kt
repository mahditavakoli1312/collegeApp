package com.example.collegeapp.features.article.data.impl

import com.example.collegeapp.features.article.data.ArticleDataSource
import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.article.data.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleDataSource: ArticleDataSource
) : ArticleRepository {

    override fun getArticle(): List<ArticleEntity> {
        return articleDataSource.getArticle()
    }

}