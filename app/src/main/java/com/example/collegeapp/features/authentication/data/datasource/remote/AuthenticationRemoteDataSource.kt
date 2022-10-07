package com.example.collegeapp.features.authentication.data.datasource.remote

import com.example.collegeapp.features.authentication.data.model.response.*

interface AuthenticationRemoteDataSource {

    suspend fun register(userRegisterRequest: UserRegisterRequest): UserRegisterResponse?

    suspend fun login(userLoginRequest: UserLoginRequest): UserLoginResponse?

    suspend fun getProfileDetails(): UserProfileResponse?
}