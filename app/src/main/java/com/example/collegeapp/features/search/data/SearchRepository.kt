package com.example.collegeapp.features.search.data

import com.example.collegeapp.features.article.data.model.ArticleEntity
import com.example.collegeapp.features.search.data.entities.UserSearchEntity

interface SearchRepository {
    fun getPosts(): List<ArticleEntity>
    fun getUsers(): List<UserSearchEntity>
    fun getTags(): List<String>

    fun getPostListBySearch(
        searchContent: String?,
    ): List<ArticleEntity>?

    fun getUserListBySearch(
        searchContent: String?,
    ): List<UserSearchEntity>?

    fun getTagListBySearch(
        searchContent: String?,
    ): List<String>?
}