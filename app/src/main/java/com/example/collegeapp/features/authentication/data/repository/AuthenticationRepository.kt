package com.example.collegeapp.features.authentication.data.repository

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.authentication.ui.model.UserLoginView
import com.example.collegeapp.features.authentication.ui.model.UserRegisterView


interface AuthenticationRepository {

    fun isLogin(): Boolean
    suspend fun login(userLoginView: UserLoginView): ResultWrapper<String>
    suspend fun register(userRegisterView: UserRegisterView): ResultWrapper<String>
    fun setUserID(userId: Int)
    fun setToken(token: String)
}