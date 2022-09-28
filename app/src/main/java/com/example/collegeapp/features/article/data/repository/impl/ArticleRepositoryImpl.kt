package com.example.collegeapp.features.article.data.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.networkUtils.safeApiCall
import com.example.collegeapp.features.article.data.datasource.local.ArticleLocalDataSource
import com.example.collegeapp.features.article.data.datasource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.model.toArticleEntity
import com.example.collegeapp.features.article.data.model.toTagEntity
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.article.ui.model.toArticleView
import com.example.collegeapp.features.article.ui.model.toTagView
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {
    //todo handle result wrapper errors in all function
    override suspend fun getArticles(): LiveData<List<ArticleView>> {
        when (val resultWrapper = safeApiCall {
            articleRemoteDataSource.getArticles()
        }) {
            is ResultWrapper.Success -> {
                resultWrapper.data?.map {
                    it.toArticleEntity()
                }.let {
                    if (it != null)
                        articleLocalDataSource.addArticles(it)
                }
            }
        }

        return articleLocalDataSource.getArticles().map {
            it.map { articleEntity ->
                articleEntity.toArticleView()
            }
        }
    }

    override suspend fun getTags(): LiveData<List<TagView>> {
        when (val resultWrapper = safeApiCall {
            articleRemoteDataSource.getTags()
        }) {
            is ResultWrapper.Success -> {
                resultWrapper.data?.map {
                    it.toTagEntity()
                }.let {
                    if (it != null)
                        articleLocalDataSource.addTags(it)
                }
            }
        }
        return articleLocalDataSource.getAllTags().map {
            it.map { tagEntity ->
                tagEntity.toTagView()
            }
        }
    }

    override suspend fun getArticleWithTags(tags: List<TagView>): LiveData<List<ArticleView>?> {
        return if (tags.isNotEmpty()) {
            articleLocalDataSource.getArticles().map {
                it.filter { articleEntity ->
                    tags.contains(articleEntity.tag.toTagView())
                }.map { articleEntity ->
                    articleEntity.toArticleView()
                }
            }
        } else {
            articleLocalDataSource.getArticles().map {
                it.map { articleEntity ->
                    articleEntity.toArticleView()
                }
            }
        }
    }

    override suspend fun getArticleWithId(articleID: Int): ArticleView? {
        return articleLocalDataSource.getArticleWithId(articleID).toArticleView()
    }

}