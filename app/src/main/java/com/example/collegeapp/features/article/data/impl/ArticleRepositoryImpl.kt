package com.example.collegeapp.features.article.data.impl

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.networkUtils.safeApiCall
import com.example.collegeapp.features.article.data.ArticleDataSource
import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.article.data.ArticleRepository
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.toArticleEntity
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleDataSource: ArticleDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {

    override fun getArticle(): List<ArticleEntity> {
        return articleDataSource.getArticle()
    }

    override suspend fun getSingleArticleRemote(id: Int): ResultWrapper<ArticleEntity?> {
        return safeApiCall {
            articleRemoteDataSource.getSingleArticle(id)?.data?.toArticleEntity()
        }
    }
}