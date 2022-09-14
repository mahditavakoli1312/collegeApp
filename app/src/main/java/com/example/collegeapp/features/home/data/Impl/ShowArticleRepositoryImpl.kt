package com.example.collegeapp.features.home.data.Impl

import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.home.data.ShowArticleDataSource
import com.example.collegeapp.features.home.data.ShowArticleRepository
import javax.inject.Inject

class ShowArticleRepositoryImpl @Inject constructor(
    private val showArticleDataSource: ShowArticleDataSource
) : ShowArticleRepository {

    override fun getArticleData(articleID: Int): ArticleEntity? {
        showArticleDataSource.getArticles().forEach {
            if (it.id == articleID)
                return it
        }
        return ArticleEntity()
    }
}