package com.example.collegeapp.features.authentication.ui.model

import com.example.collegeapp.features.authentication.data.model.response.UserProfileResponse

data class UserProfileView(
    val id: Int = -1,
    val fullName: String?,
)

fun UserProfileResponse.toUserProfileView() =
    UserProfileView(
        id = id,
        fullName = "$firstName $lastName"
    )
