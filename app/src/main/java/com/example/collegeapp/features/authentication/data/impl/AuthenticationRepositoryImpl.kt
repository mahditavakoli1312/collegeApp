package com.example.collegeapp.features.authentication.data.impl

import com.example.collegeapp.features.authentication.data.AuthenticationDataSource
import com.example.collegeapp.features.authentication.data.AuthenticationRepository
import com.example.collegeapp.features.authentication.data.UserRegisterEntity
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationDataSource: AuthenticationDataSource
) : AuthenticationRepository {

    /*
      TODO The following methods should be changed based on the APIs
    */

    override fun isLogin(): Boolean {
        return authenticationDataSource.isLogin()
    }

    override fun login(username: String, password: String): Boolean {
        return authenticationDataSource.login(username, password)
    }

    override fun register(userRegisterEntity: UserRegisterEntity): Boolean {
        return authenticationDataSource.register(userRegisterEntity)
    }

}