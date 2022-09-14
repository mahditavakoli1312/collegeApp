package com.example.collegeapp.features.authentication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.authentication.data.AuthenticationRepository
import com.example.collegeapp.features.authentication.data.UserRegisterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    val sharedPhoneNumber = MutableLiveData<String>()
    val sharedPassword = MutableLiveData<String>()

    fun setSharedPassword(password: String) {
        sharedPassword.value = password
    }

    fun setSharedPhNumber(username: String) {
        sharedPhoneNumber.value = username
    }

    /*
      TODO The following methods should be changed based on the APIs
    */

    fun isLogin(): Boolean {
        return authenticationRepository.isLogin()
    }

    fun login(username: String, password: String): Boolean {
        return authenticationRepository.login(username, password)
    }

    fun register(userRegisterEntity: UserRegisterEntity): Boolean {
        return authenticationRepository.register(userRegisterEntity)
    }
}