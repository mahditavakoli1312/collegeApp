package com.example.collegeapp.features.authentication.data

data class UserRegisterEntity(
    val username: String,
    val password: String,
    val fullName: String,
    val email: String,
    val phNumber: String
)
