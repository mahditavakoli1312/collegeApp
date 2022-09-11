package com.example.collegeapp.features.profile.data

import com.example.collegeapp.features.search.data.entities.MyArticleEntity

interface MyArticleRepository {
    fun getArticle(): List<MyArticleEntity>
}