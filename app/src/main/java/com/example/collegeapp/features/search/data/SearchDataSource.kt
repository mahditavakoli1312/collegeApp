package com.example.collegeapp.features.search.data

import android.content.Context
import com.example.collegeapp.core.data.searchTagLists
import com.example.collegeapp.search.data.searchPostLists
import com.example.collegeapp.search.data.searchUserLists
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SearchDataSource @Inject constructor(
    @ApplicationContext val context: Context
) {

    fun getPosts() = searchPostLists(context)
    fun getUsers() = searchUserLists(context)
    fun getTags() = searchTagLists()
}