package com.example.collegeapp.features.profile.data.repository.impl

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.networkUtils.safeApiCall
import com.example.collegeapp.features.article.data.datasource.local.ArticleLocalDataSource
import com.example.collegeapp.features.article.data.datasource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.authentication.data.datasource.local.impl.AuthenticationLocalDataSourceImpl
import com.example.collegeapp.features.authentication.data.datasource.remote.AuthenticationRemoteDataSource
import com.example.collegeapp.features.authentication.ui.model.UserProfileView
import com.example.collegeapp.features.authentication.ui.model.toUserProfileView
import com.example.collegeapp.features.profile.data.model.entity.UserArticleDataEntity
import com.example.collegeapp.features.profile.data.model.entity.toUserArticleDataEntity
import com.example.collegeapp.features.profile.data.repository.ProfileArticleRepository
import com.example.collegeapp.features.profile.ui.model.UserArticleDataView
import com.example.collegeapp.features.profile.ui.model.toUserArticleDataView
import javax.inject.Inject

class ProfileArticleRepositoryImpl @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource,
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource,
    private val authenticationLocalDataSource: AuthenticationLocalDataSourceImpl
) : ProfileArticleRepository {

    private suspend fun getUserArticleByAuthorIdFromRemote(authorId: Int): List<UserArticleDataEntity>? =
        articleRemoteDataSource.getArticleByAuthorId(id = authorId)
            ?.map { userArticleDataResponse ->
                userArticleDataResponse.toUserArticleDataEntity()
            }

    private suspend fun insertUserArticle(userArticles: List<UserArticleDataEntity>) =
        articleLocalDataSource.insertUserArticle(userArticles = userArticles)

    private suspend fun getUserArticleByAuthorIdFromLocal(authorId: Int): List<UserArticleDataView> =
        articleLocalDataSource.getUserArticleByAuthorId(authorId = authorId)
            .map { userArticleDataEntity ->
                userArticleDataEntity.toUserArticleDataView()
            }

    override suspend fun getUserArticleByAuthorId(authorId: Int): ResultWrapper<List<UserArticleDataView>?> =
        safeApiCall(
            localData = getUserArticleByAuthorIdFromLocal(authorId = authorId),
            api = {
                getUserArticleByAuthorIdFromRemote(authorId = authorId)?.let { userArticles ->
                    insertUserArticle(userArticles = userArticles)
                }
                return@safeApiCall getUserArticleByAuthorIdFromLocal(authorId = authorId)
            }
        )

    override fun setUserID(userId: Int) =
        authenticationLocalDataSource.setUserID(userId = userId)

    override fun getUserID(): Int =
        authenticationLocalDataSource.getUserID()

    override fun setUserFullName(fullName: String) =
        authenticationLocalDataSource.setUserFullName(fullName = fullName)

    override fun getUserFullName(): String =
        authenticationLocalDataSource.getUserFullName()

    private fun getProfileDetailsFromLocal(): UserProfileView? =
        UserProfileView(
            id = getUserID(),
            fullName = getUserFullName()
        )

    private fun insertProfileDetailsToLocal(userProfileView: UserProfileView?) {
        setUserID(userProfileView?.id ?: -1)
        setUserFullName(userProfileView?.fullName ?: "")
    }

    override suspend fun getProfileDetails(): ResultWrapper<UserProfileView?> {
        return safeApiCall(
            localData = getProfileDetailsFromLocal(),
            api = {
                val remoteData =
                    authenticationRemoteDataSource.getProfileDetails()?.toUserProfileView()
                insertProfileDetailsToLocal(remoteData)
                return@safeApiCall getProfileDetailsFromLocal()
            }
        )
    }
}