package com.example.collegeapp.features.article.data.datasource.remote.impl

import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.article.data.datasource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.model.response.*
import com.example.collegeapp.features.article.data.network.api.ArticleApi
import com.example.collegeapp.features.profile.data.model.response.UserArticleDataResponse
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

    override suspend fun getArticleByAuthorId(id: Int): List<UserArticleDataResponse>? =
        api.getArticleByAuthorId(authorId = id).bodyOrThrow()?.data

    override suspend fun addArticle(addArticleRequest: AddArticleRequest): AddArticleResponse? {
        return api.addArticle(addArticleRequest).bodyOrThrow()
    }
}