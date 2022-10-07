package com.example.collegeapp.features.search.ui.model

import com.example.collegeapp.features.search.data.model.response.SearchUserResponse

data class SearchUserView(
    val id: Int,
    val nameUser: String
)

fun SearchUserResponse.toSearchUserView() =
    SearchUserView(
        id = id ?: -1,
        nameUser = "$firstName $lastName"
    )