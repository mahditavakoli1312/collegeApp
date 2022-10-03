package com.example.collegeapp.features.authentication.ui.model

data class UserRegisterView(
    var username: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var password: String = "",
    var email: String = "",
    var phoneNumber: String = ""
)
