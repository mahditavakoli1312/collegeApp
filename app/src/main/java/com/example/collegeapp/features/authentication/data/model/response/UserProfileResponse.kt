package com.example.collegeapp.features.authentication.data.model.response

import com.google.gson.annotations.SerializedName

data class UserProfileResponse(
    val id: Int = -1,
    val username: String? = null,
    @SerializedName("first_name") val firstName: String? = null,
    val email: String? = null,
    @SerializedName("phone_number") val phoneNumber: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("last_name") val lastName: String? = null
)
