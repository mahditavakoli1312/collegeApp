package com.example.collegeapp.features.article.data.repository

import androidx.lifecycle.LiveData
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView

interface ArticleRepository {

    suspend fun getArticles(): LiveData<List<ArticleView>>
    suspend fun getTags(): LiveData<List<TagView>>
    suspend fun getArticleWithTags(tags: List<TagView>): LiveData<List<ArticleView>?>
    suspend fun getArticleWithId(articleID: Int): ArticleView?

}