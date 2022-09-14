package com.example.collegeapp.features.home.data

import android.content.Context
import com.example.collegeapp.core.data.getHomeFakeTags
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun getHomeTags() = getHomeFakeTags(context)
}