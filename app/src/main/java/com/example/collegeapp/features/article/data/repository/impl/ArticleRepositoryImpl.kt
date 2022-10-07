package com.example.collegeapp.features.article.data.repository.impl

import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.networkUtils.safeApiCall
import com.example.collegeapp.features.article.data.dataSource.local.ArticleLocalDataSource
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.model.entity.*
import com.example.collegeapp.features.article.data.model.response.toAddArticleRequest
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.*
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource
) : ArticleRepository {
    //todo handle result wrapper errors in all function
    override suspend fun getArticles(): ResultWrapper<List<ArticleView>> {
        return safeApiCall(
            localData = getArticleFromLocalDataSource(),
            api = {
                val response = articleRemoteDataSource.getArticles()
                    ?.map { articleDataResponse -> articleDataResponse.toArticleEntity() }
                if (response != null)
                    articleLocalDataSource.insertArticles(response)
                return@safeApiCall getArticleFromLocalDataSource()
            }
        )
    }

    private suspend fun getArticleFromLocalDataSource(): List<ArticleView> {
        return articleLocalDataSource.getArticles().map { articleEntity ->
            articleEntity.toArticleView()
        }
    }


    private suspend fun insertTags(tags: List<TagEntity>) =
        articleLocalDataSource.insertTags(tags)


    private suspend fun getTagEntityFromRemoteDataSource(): List<TagEntity>? {
        val res = articleRemoteDataSource.getTags()?.map { articleTagResponse ->
            articleTagResponse.toTagEntity()
        }
        return res
    }


    private suspend fun getTagsViewFromLocalDataSource(): List<TagView> {
        val res = articleLocalDataSource.getAllTags().map { tagsEntitys ->
            tagsEntitys.toTagView()
        }
        return res
    }


    override suspend fun getTags(): ResultWrapper<List<TagView>> {
        return safeApiCall(
            localData = getTagsViewFromLocalDataSource(),
            api = {
                getTagEntityFromRemoteDataSource().let { tagsEntity ->
                    if (tagsEntity !== null)
                        insertTags(tagsEntity)
                }
                return@safeApiCall getTagsViewFromLocalDataSource()
            }
        )
    }

    override suspend fun getArticleWithTags(tags: List<TagView>): List<ArticleView> {
        return if (tags.isNotEmpty()) {
            articleLocalDataSource.getArticles().filter { articleEntity ->
                tags.contains(articleEntity.tag.toTagView())
            }.map { articleEntity ->
                articleEntity.toArticleView()
            }
        } else {
            articleLocalDataSource.getArticles().map { articleEntity ->
                articleEntity.toArticleView()
            }
        }
    }


    override suspend fun getArticleWithId(articleID: Int): ArticleView {
        return articleLocalDataSource.getArticleWithId(articleID).toArticleView()
    }

    private suspend fun getArticleDetailsEntityByIdFromRemoteDataSource(id: Int): ArticleDetailsEntity? =
        articleRemoteDataSource.getArticleDetails(id)?.data?.toArticleDetailsEntity()

    private suspend fun insertArticleDetailsToLocalDatabase(article: ArticleDetailsEntity) =
        articleLocalDataSource.insertArticleDetails(article)

    private fun getArticleViewByIdFromLocalDataSource(id: Int): ArticleView? =
        articleLocalDataSource.getArticleDetailsById(id)?.toArticleView()


    override suspend fun getArticleDetails(id: Int): ResultWrapper<ArticleView?> {
        return safeApiCall(
            localData = getArticleViewByIdFromLocalDataSource(id),
            api = {
                getArticleDetailsEntityByIdFromRemoteDataSource(id).let { remoteData ->
                    if (remoteData != null)
                        insertArticleDetailsToLocalDatabase(remoteData)
                }
                return@safeApiCall getArticleViewByIdFromLocalDataSource(id)
            })
    }

    override suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) =
        articleLocalDataSource.insertBookmark(bookmarkEntity = bookmarkEntity)

    override suspend fun removeBookmarkByServerId(serverId: Int) =
        articleLocalDataSource.removeBookmarkByServerId(serverId = serverId)

    override suspend fun bookmarksIsExist(serverId: Int): Boolean =
        articleLocalDataSource.bookmarksIsExist(serverId = serverId)

    override suspend fun addArticle(addArticleView: AddArticleView): ResultWrapper<String> {
        return safeApiCall(
            localData = ConstanceValue.FAILURE,
            api = {
                val response =
                    articleRemoteDataSource.addArticle(addArticleView.toAddArticleRequest())
                return@safeApiCall response?.message ?: ""
            }
        )
    }


}