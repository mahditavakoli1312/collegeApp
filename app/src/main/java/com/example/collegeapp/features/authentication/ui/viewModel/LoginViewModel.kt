package com.example.collegeapp.features.authentication.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.authentication.data.repository.AuthenticationRepository
import com.example.collegeapp.features.authentication.ui.model.UserLoginView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    val phoneNumber = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _loginMessage = MutableLiveData<String>()
    val loginMessage = _loginMessage
    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            val responseLogin = authenticationRepository.login(
                UserLoginView(
                    phoneNumber.value,
                    password.value
                )
            )
            when (responseLogin) {
                is ResultWrapper.ApplicationError -> _loginMessage.postValue(responseLogin.message)
                is ResultWrapper.Failure -> _loginMessage.postValue(responseLogin.message)
                is ResultWrapper.Success -> {
                    authenticationRepository.setToken(responseLogin.data)
                    _loginMessage.postValue(ConstanceValue.SUCCESS)
                }
            }
        }
    }


}