package com.example.collegeapp.features.search.ui.model

import com.example.collegeapp.features.search.data.model.response.SearchUserResponse

data class SearchUserView(
    val nameUser: String
)

fun SearchUserResponse.toSearchUserView() =
    SearchUserView(
        nameUser = "$firstName $lastName"
    )