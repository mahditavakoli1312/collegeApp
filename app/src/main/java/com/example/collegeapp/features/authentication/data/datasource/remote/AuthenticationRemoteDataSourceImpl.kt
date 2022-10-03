package com.example.collegeapp.features.authentication.data.datasource.remote

import android.util.Log
import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.authentication.data.model.response.UserLoginRequest
import com.example.collegeapp.features.authentication.data.model.response.UserLoginResponse
import com.example.collegeapp.features.authentication.data.model.response.UserRegisterRequest
import com.example.collegeapp.features.authentication.data.model.response.UserRegisterResponse
import com.example.collegeapp.features.authentication.data.network.api.AuthenticationApi
import javax.inject.Inject

class AuthenticationRemoteDataSourceImpl @Inject constructor(
    private val authenticationApi: AuthenticationApi
) : AuthenticationRemoteDataSource {

    override suspend fun register(userRegisterRequest: UserRegisterRequest): UserRegisterResponse? {
        return authenticationApi.registerUser(userRegisterRequest).bodyOrThrow()
    }

    override suspend fun login(userLoginRequest: UserLoginRequest): UserLoginResponse? {
        Log.d("Taggi", "login: "+userLoginRequest.toString())
        return authenticationApi.loginUser(userLoginRequest).bodyOrThrow()
    }

}