package com.example.collegeapp.features.authentication.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.authentication.data.repository.AuthenticationRepository
import com.example.collegeapp.features.authentication.ui.model.UserRegisterView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    var name = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var phoneNumber = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    private val _registerMessage = MutableLiveData<String>()
    val registerMessage = _registerMessage
    fun register() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = authenticationRepository
                .register(
                    UserRegisterView(
                        firstName = name.value ?: "",
                        lastName = lastName.value ?: "",
                        username = username.value ?: "",
                        password = password.value ?: "",
                        phoneNumber = phoneNumber.value ?: "",
                        email = email.value ?: ""
                    )
                )) {
                is ResultWrapper.ApplicationError -> _registerMessage.postValue(response.message)
                is ResultWrapper.Failure -> {
                    _registerMessage.postValue("${response.message} ${response.code}")
                }
                is ResultWrapper.Success -> _registerMessage.postValue(ConstanceValue.SUCCESS)
            }
        }
    }

}