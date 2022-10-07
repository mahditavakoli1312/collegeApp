package com.example.collegeapp.features.authentication.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.authentication.data.repository.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    fun isLogin(): Boolean {
        return authenticationRepository.isLogin()
    }
}