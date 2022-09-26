package com.example.collegeapp.features.article.data.dataSource.remote.impl

import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleApi
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.model.ArticleBaseResponse
import javax.inject.Inject

class ArticleRemoteDataSourceImpl @Inject constructor(
    private val api: ArticleApi
) : ArticleRemoteDataSource {
    override suspend fun getSingleArticle(id: Int): ArticleBaseResponse? {
        return api.getSingleArticle(id).bodyOrThrow()
    }

}