package com.example.collegeapp.features.search.data.repository.impl

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.networkUtils.safeApiCall
import com.example.collegeapp.features.search.data.dataSource.remote.SearchRemoteDataSource
import com.example.collegeapp.features.search.data.model.response.toSearchBodyRequest
import com.example.collegeapp.features.search.data.repository.SearchRepository
import com.example.collegeapp.features.search.ui.model.SearchBaseView
import com.example.collegeapp.features.search.ui.model.SearchBodyView
import com.example.collegeapp.features.search.ui.model.toSearchBaseView
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource
) : SearchRepository {
    override suspend fun search(searchContent: SearchBodyView): ResultWrapper<SearchBaseView?> =
        safeApiCall(
            localData = null,
            api = {
                remoteDataSource.search(searchContent = searchContent.toSearchBodyRequest())
                    ?.toSearchBaseView()
            }
        )
}