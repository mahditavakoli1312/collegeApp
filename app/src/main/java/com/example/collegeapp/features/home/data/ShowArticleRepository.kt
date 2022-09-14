package com.example.collegeapp.features.home.data

import com.example.collegeapp.features.article.data.ArticleEntity

interface ShowArticleRepository {
    fun getArticleData(articleID : Int) : ArticleEntity?
}