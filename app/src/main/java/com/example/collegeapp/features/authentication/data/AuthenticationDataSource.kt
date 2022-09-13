package com.example.collegeapp.features.authentication.data

import javax.inject.Inject

class AuthenticationDataSource @Inject constructor() {

    /*
      The following methods should be changed based on the APIs
    */

    fun isLogin(): Boolean {
        return true
    }

    fun login(username: String, password: String): Boolean {
        return true
    }

    fun register(
        username: String,
        password: String,
        fullname: String,
        email: String,
        phNumber: String
    ): Boolean {
        return true
    }

}