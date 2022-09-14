package com.example.collegeapp.features.home.data.impl

import com.example.collegeapp.features.article.data.ArticleDataSource
import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.home.data.HomeDataSource
import com.example.collegeapp.features.home.data.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource,
    private val articleDataSource: ArticleDataSource
) : HomeRepository {

    override fun getHomeTags() = homeDataSource.getHomeTags()

    override fun getArticleWithTag(tags: List<String>): List<ArticleEntity> {
        return if (tags.isNotEmpty()) {
            articleDataSource.getArticle().filter {
                tags.contains(it.tag)
            }
        } else {
            articleDataSource.getArticle()
        }
    }

}