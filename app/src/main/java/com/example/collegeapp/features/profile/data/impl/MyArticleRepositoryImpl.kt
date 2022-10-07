package com.example.collegeapp.features.profile.data.impl

import com.example.collegeapp.features.article.data.dataSource.local.ArticleLocalDataSource
import com.example.collegeapp.features.profile.data.MyArticleRepository
import com.example.collegeapp.features.profile.ui.model.MyArticleView
import javax.inject.Inject

class MyArticleRepositoryImpl @Inject constructor(
    private val articleDataSource: ArticleLocalDataSource
) : MyArticleRepository {
    override fun getArticle(): List<MyArticleView> {
        return listOf()
    }
    //todo Change this
}