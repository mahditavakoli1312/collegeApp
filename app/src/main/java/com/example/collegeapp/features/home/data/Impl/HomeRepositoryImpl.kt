package com.example.collegeapp.features.home.data.Impl

import com.example.collegeapp.features.home.data.HomeDataSource
import com.example.collegeapp.features.home.data.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override fun getHomeTags() = homeDataSource.getHomeTags()
}