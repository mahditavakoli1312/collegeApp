package com.example.collegeapp.features.search.data.model.response

data class SearchBaseResponse(
    val users: List<SearchUserResponse> = listOf(),
    val tags: List<SearchTagResponse> = listOf(),
    val articles: List<SearchArticleResponse> = listOf()
)