package com.example.collegeapp.features.search.data.dataSource.local.impl

import android.content.Context
import com.example.collegeapp.core.data.searchPostLists
import com.example.collegeapp.core.data.searchTagLists
import com.example.collegeapp.features.search.data.dataSource.local.SearchLocalDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SearchLocalDataSourceImpl @Inject constructor(
    @ApplicationContext val context: Context
) : SearchLocalDataSource {
    override fun getPosts() = searchPostLists()
    override fun getTags() = searchTagLists(context)
}