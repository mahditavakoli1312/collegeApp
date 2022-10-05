package com.example.collegeapp.features.search.ui.model

import com.example.collegeapp.features.search.data.model.response.SearchTagResponse

data class SearchTagView(
    val id: Int? = null,
    val name: String? = null
) {
    override fun toString(): String {
        return name.toString()
    }
}

fun SearchTagResponse.toSearchTagView() =
    SearchTagView(
        id = id,
        name = name
    )