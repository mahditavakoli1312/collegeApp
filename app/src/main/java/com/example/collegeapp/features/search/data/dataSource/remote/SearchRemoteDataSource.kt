package com.example.collegeapp.features.search.data.dataSource.remote

import com.example.collegeapp.features.search.data.model.response.SearchBaseResponse
import com.example.collegeapp.features.search.data.model.response.SearchBodyRequest

interface SearchRemoteDataSource {
    suspend fun search(searchContent: SearchBodyRequest): SearchBaseResponse?
}