package com.example.collegeapp.features.article.data

import android.content.Context
import com.example.collegeapp.core.data.articleList
import com.example.collegeapp.core.data.myArticlesPostsLists
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ArticleDataSource @Inject constructor(
    @ApplicationContext val context: Context
) {

    fun getArticle() = articleList(context)

    fun getMyArticle() = myArticlesPostsLists(context)

}