package com.example.collegeapp.features.search.data.model.response

import com.example.collegeapp.features.search.ui.model.SearchBodyView
import com.google.gson.annotations.SerializedName

data class SearchBodyRequest(
    @SerializedName("search_text") var searchText: String? = null
)

fun SearchBodyView.toSearchBodyRequest() =
    SearchBodyRequest(
        searchText = searchText
    )