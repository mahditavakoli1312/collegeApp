package com.example.collegeapp.features.authentication.data.model.response

import com.example.collegeapp.features.authentication.ui.model.UserLoginView
import com.google.gson.annotations.SerializedName

data class UserLoginRequest(
    @SerializedName("phone_number")
    val phoneNumber: String,
    val password: String
)

fun UserLoginView.toUserLoginRequest() = UserLoginRequest(
    phoneNumber = phoneNumber ?: "",
    password = password ?: ""
)