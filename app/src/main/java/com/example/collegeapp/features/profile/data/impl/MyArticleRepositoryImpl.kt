package com.example.collegeapp.features.profile.data.impl

import com.example.collegeapp.features.article.data.datasource.local.ArticleLocalDataSource
import com.example.collegeapp.features.profile.data.MyArticleRepository
import com.example.collegeapp.features.search.data.entities.MyArticleEntity
import javax.inject.Inject

class MyArticleRepositoryImpl @Inject constructor(
    private val articleDataSource: ArticleLocalDataSource
) : MyArticleRepository {
    override fun getArticle(): List<MyArticleEntity> {
        return listOf()
    }
    //todo Change this
}