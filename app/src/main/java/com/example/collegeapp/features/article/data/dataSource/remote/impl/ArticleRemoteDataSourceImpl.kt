package com.example.collegeapp.features.article.data.datasource.remote.impl

import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.article.data.datasource.remote.ArticleApi
import com.example.collegeapp.features.article.data.datasource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.model.ArticleBaseResponse
import com.example.collegeapp.features.article.data.model.ArticleDataResponse
import com.example.collegeapp.features.article.data.model.ArticleTagResponse
import com.example.collegeapp.features.article.data.model.TagBaseResponse
import javax.inject.Inject

class ArticleRemoteDataSourceImpl @Inject constructor(
    private val api: ArticleApi
) : ArticleRemoteDataSource {
    override suspend fun getSingleArticle(id: Int): ArticleBaseResponse? {
        return api.getSingleArticle(id).bodyOrThrow()
    }

    override suspend fun getArticles(): List<ArticleDataResponse>? {
        return api.getArticles().bodyOrThrow()?.data
    }

    override suspend fun getTags(): List<ArticleTagResponse>? {
        return api.getTags().bodyOrThrow()?.data
    }

}