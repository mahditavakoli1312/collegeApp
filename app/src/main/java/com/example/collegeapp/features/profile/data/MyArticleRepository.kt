package com.example.collegeapp.features.profile.data

import com.example.collegeapp.features.profile.ui.model.MyArticleView

interface MyArticleRepository {
    fun getArticle(): List<MyArticleView>
}