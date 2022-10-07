package com.example.collegeapp.features.authentication.data.datasource.remote.impl

import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.authentication.data.datasource.remote.AuthenticationRemoteDataSource
import com.example.collegeapp.features.authentication.data.model.response.*
import com.example.collegeapp.features.authentication.data.network.api.AuthenticationApi
import javax.inject.Inject

class AuthenticationRemoteDataSourceImpl @Inject constructor(
    private val authenticationApi: AuthenticationApi
) : AuthenticationRemoteDataSource {

    override suspend fun register(userRegisterRequest: UserRegisterRequest): UserRegisterResponse? {
        return authenticationApi.registerUser(userRegisterRequest).bodyOrThrow()
    }

    override suspend fun login(userLoginRequest: UserLoginRequest): UserLoginResponse? {
        return authenticationApi.loginUser(userLoginRequest).bodyOrThrow()
    }

    override suspend fun getProfileDetails(): UserProfileResponse? =
        authenticationApi.getProfileDetails()?.bodyOrThrow()

}