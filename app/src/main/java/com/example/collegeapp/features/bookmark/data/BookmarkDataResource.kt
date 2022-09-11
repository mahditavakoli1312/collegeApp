package com.example.collegeapp.features.bookmark.data

import android.content.Context
import com.example.collegeapp.search.data.searchPostLists
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BookmarkDataResource @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun getBookmark() = searchPostLists(context)
}