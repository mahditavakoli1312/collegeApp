package com.example.collegeapp.features.article.data

import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleDataSource: ArticleDataSource
) : ArticleRepository {
    override fun getArticle(): List<ArticleEntity> {
        return articleDataSource.getArticle()
    }
}