package com.example.collegeapp.features.home.data

import com.example.collegeapp.core.data.getHomeFakeTags
import javax.inject.Inject

class HomeDataSource @Inject constructor() {
    fun getHomeTags() = getHomeFakeTags()
}