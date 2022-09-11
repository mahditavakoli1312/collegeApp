package com.example.collegeapp.features.search.data

import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.search.data.entities.UserSearchEntity

interface SearchRepository {

    fun getPosts(): List<ArticleEntity>
    fun getUsers(): List<UserSearchEntity>
    fun getTags(): List<String>
}