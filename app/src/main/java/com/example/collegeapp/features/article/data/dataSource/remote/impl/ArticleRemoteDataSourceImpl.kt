package com.example.collegeapp.features.article.data.dataSource.remote.impl

import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.model.response.ArticleDataResponse
import com.example.collegeapp.features.article.data.model.response.ArticleDetailBaseResponse
import com.example.collegeapp.features.article.data.model.response.ArticleTagResponse
import com.example.collegeapp.features.article.data.network.api.ArticleApi
import javax.inject.Inject

class ArticleRemoteDataSourceImpl @Inject constructor(
    private val api: ArticleApi
) : ArticleRemoteDataSource {
    override suspend fun getArticleDetails(id: Int): ArticleDetailBaseResponse? {
        return api.getArticleDetails(id).bodyOrThrow()
    }

    override suspend fun getArticles(): List<ArticleDataResponse>? {
        return api.getArticles().bodyOrThrow()?.data
    }

    override suspend fun getTags(): List<ArticleTagResponse>? {
        return api.getTags().bodyOrThrow()?.data
    }

}