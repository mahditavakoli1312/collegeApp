package com.example.collegeapp.features.search.data.dataSource.remote.impl

import com.example.collegeapp.core.networkUtils.bodyOrThrow
import com.example.collegeapp.features.search.data.dataSource.remote.SearchRemoteDataSource
import com.example.collegeapp.features.search.data.model.response.SearchBaseResponse
import com.example.collegeapp.features.search.data.model.response.SearchBodyRequest
import com.example.collegeapp.features.search.data.network.api.SearchApi
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val searchApi: SearchApi
) : SearchRemoteDataSource {
    override suspend fun search(searchContent: SearchBodyRequest): SearchBaseResponse? =
        searchApi.serach(searchContent).bodyOrThrow()
}