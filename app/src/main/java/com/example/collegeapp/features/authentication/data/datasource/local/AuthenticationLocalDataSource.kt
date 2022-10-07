package com.example.collegeapp.features.authentication.data.datasource.local

interface AuthenticationLocalDataSource {
    fun isLogin(): Boolean
    fun setAccessToken(token: String)
    fun setUserID(userId: Int)
    fun getUserID(): Int
    fun setUserFullName(fullName: String)
    fun getUserFullName(): String
}