package com.example.collegeapp.features.article.data

import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val articleDataSource: ArticleDataSource
) : ArticleRepositoryImpl {

    override fun getArticle(): List<ArticleEntity> {
        return articleDataSource.getArticle()
    }

}