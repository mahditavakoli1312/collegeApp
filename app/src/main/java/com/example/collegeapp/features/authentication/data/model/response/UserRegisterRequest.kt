package com.example.collegeapp.features.authentication.data.model.response

import com.example.collegeapp.features.authentication.ui.model.UserRegisterView
import com.google.gson.annotations.SerializedName

data class UserRegisterRequest(
    var username: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("last_name")
    var lastName: String,
    var password: String,
    var email: String,
    @SerializedName("phone_number")
    var phoneNumber: String
)

fun UserRegisterView.toRegisterRequest() = UserRegisterRequest(
    username = username,
    firstName = firstName,
    lastName = lastName,
    password = password,
    email = email,
    phoneNumber = phoneNumber
)
