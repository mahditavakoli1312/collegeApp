package com.example.collegeapp.features.home.data

import android.content.Context
import com.example.collegeapp.core.data.articleList
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ShowArticleDataSource @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun getArticles() = articleList(context)
}