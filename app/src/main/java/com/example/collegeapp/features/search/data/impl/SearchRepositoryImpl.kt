package com.example.collegeapp.features.search.data.impl

import com.example.collegeapp.features.search.data.SearchDataSource
import com.example.collegeapp.features.search.data.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override fun getPosts() = dataSource.getPosts()
    override fun getUsers() = dataSource.getUsers()
    override fun getTags() = dataSource.getTags()
}