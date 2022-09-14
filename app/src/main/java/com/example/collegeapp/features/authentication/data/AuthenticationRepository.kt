package com.example.collegeapp.features.authentication.data


interface AuthenticationRepository {

    fun isLogin(): Boolean
    fun login(username: String, password: String): Boolean
    fun register(userRegisterEntity: UserRegisterEntity): Boolean

}