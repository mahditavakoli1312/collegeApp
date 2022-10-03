package com.example.collegeapp.features.authentication.data.datasource.remote

import com.example.collegeapp.features.authentication.data.model.response.UserLoginRequest
import com.example.collegeapp.features.authentication.data.model.response.UserLoginResponse
import com.example.collegeapp.features.authentication.data.model.response.UserRegisterRequest
import com.example.collegeapp.features.authentication.data.model.response.UserRegisterResponse

interface AuthenticationRemoteDataSource {

    suspend fun register(userRegisterRequest: UserRegisterRequest) : UserRegisterResponse?

    suspend fun login(userLoginRequest: UserLoginRequest) : UserLoginResponse?
}