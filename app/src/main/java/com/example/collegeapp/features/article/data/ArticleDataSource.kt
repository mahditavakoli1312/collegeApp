package com.example.collegeapp.features.article.data

import android.content.Context
import com.example.collegeapp.core.data.RecyclerDataTemp
import com.example.collegeapp.profile.data.myArticlesPostsLists
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ArticleDataSource @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun getArticle() = RecyclerDataTemp().articleList(context)

    fun getMyArticle() = myArticlesPostsLists(context)
}