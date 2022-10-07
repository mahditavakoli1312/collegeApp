package com.example.collegeapp.features.authentication.data.network.api

import com.example.collegeapp.features.authentication.data.model.response.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("auth/signup")
    suspend fun registerUser(@Body userRegisterRequest: UserRegisterRequest): Response<UserRegisterResponse>

    @POST("auth/login")
    suspend fun loginUser(@Body userLoginRequest: UserLoginRequest): Response<UserLoginResponse>

    @GET("user")
    suspend fun getProfileDetails(): Response<UserProfileResponse>?
}