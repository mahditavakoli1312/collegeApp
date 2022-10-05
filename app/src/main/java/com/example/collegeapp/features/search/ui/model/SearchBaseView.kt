package com.example.collegeapp.features.search.ui.model

import com.example.collegeapp.features.search.data.model.response.SearchBaseResponse

data class SearchBaseView(
    val users: List<SearchUserView> = listOf(),
    val tags: List<SearchTagView> = listOf(),
    val articles: List<SearchArticleView> = listOf()
)

fun SearchBaseResponse.toSearchBaseView() =
    SearchBaseView(
        users = users.map { searchUserResponse ->
            searchUserResponse.toSearchUserView()
        },
        tags = tags.map { searchTagResponse ->
            searchTagResponse.toSearchTagView()
        },
        articles = articles.map { searchArticleResponse ->
            searchArticleResponse.toSearchArticleView()
        }
    )