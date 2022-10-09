package com.example.collegeapp.features.authentication.data.repository.impl

import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.networkUtils.safeApiCall
import com.example.collegeapp.features.authentication.data.datasource.local.AuthenticationLocalDataSource
import com.example.collegeapp.features.authentication.data.datasource.remote.AuthenticationRemoteDataSource
import com.example.collegeapp.features.authentication.data.model.response.toRegisterRequest
import com.example.collegeapp.features.authentication.data.model.response.toUserLoginRequest
import com.example.collegeapp.features.authentication.data.repository.AuthenticationRepository
import com.example.collegeapp.features.authentication.ui.model.UserLoginView
import com.example.collegeapp.features.authentication.ui.model.UserRegisterView
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationLocalDataSource: AuthenticationLocalDataSource,
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource
) : AuthenticationRepository {

    override fun isLogin(): Boolean {
        return authenticationLocalDataSource.isLogin()
    }

    override fun setUserID(userId: Int) {
        authenticationLocalDataSource.setUserID(userId)
    }

    override fun setToken(token: String) {
        authenticationLocalDataSource.setAccessToken(token)
    }

    override suspend fun login(userLoginView: UserLoginView): ResultWrapper<String> {
        return safeApiCall(
            localData = ConstanceValue.FAILURE,
            api = {
                val response = authenticationRemoteDataSource
                    .login(userLoginView.toUserLoginRequest())
                return@safeApiCall response?.accessToken ?: ""
            }
        )
    }

    override suspend fun register(userRegisterView: UserRegisterView): ResultWrapper<String> {
        return safeApiCall(
            localData = ConstanceValue.FAILURE,
            api = {
                val response = authenticationRemoteDataSource
                    .register(userRegisterView.toRegisterRequest())
                return@safeApiCall response?.message?.get(0) ?: ConstanceValue.FAILURE
            }
        )
    }


}