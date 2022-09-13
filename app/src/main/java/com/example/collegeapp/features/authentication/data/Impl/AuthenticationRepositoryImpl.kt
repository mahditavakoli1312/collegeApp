package com.example.collegeapp.features.authentication.data.Impl

import com.example.collegeapp.features.authentication.data.AuthenticationDataSource
import com.example.collegeapp.features.authentication.data.AuthenticationRepository
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationDataSource: AuthenticationDataSource
) : AuthenticationRepository {

    /*
     The following methods should be changed based on the APIs
    */

    override fun isLogin(): Boolean {
        return authenticationDataSource.isLogin()
    }

    override fun login(username: String, password: String): Boolean {
        return authenticationDataSource.login(username, password)
    }

    override fun register(
        username: String,
        password: String,
        fullname: String,
        email: String,
        phNumber: String
    ): Boolean {
        return authenticationDataSource.register(username, password, fullname, email, phNumber)
    }

}