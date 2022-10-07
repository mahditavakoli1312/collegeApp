package com.example.collegeapp.features.profile.data.repository

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.authentication.ui.model.UserProfileView
import com.example.collegeapp.features.profile.ui.model.UserArticleDataView

interface ProfileArticleRepository {
    suspend fun getUserArticleByAuthorId(authorId: Int): ResultWrapper<List<UserArticleDataView>?>
    suspend fun getProfileDetails(): ResultWrapper<UserProfileView?>
    fun setUserID(userId: Int)
    fun getUserID(): Int
    fun setUserFullName(fullName: String)
    fun getUserFullName(): String
}