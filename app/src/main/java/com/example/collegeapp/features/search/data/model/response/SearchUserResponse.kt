package com.example.collegeapp.features.search.data.model.response

import com.google.gson.annotations.SerializedName

data class SearchUserResponse(
    val id: Int? = null,
    @SerializedName("first_name") val firstName: String? = null,
    @SerializedName("last_name") val lastName: String? = null,
    val bio: String? = null
)