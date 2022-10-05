package com.example.collegeapp.features.search.data.repository

import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.search.ui.model.SearchBaseView
import com.example.collegeapp.features.search.ui.model.SearchBodyView

interface SearchRepository {
    suspend fun search(searchContent: SearchBodyView): ResultWrapper<SearchBaseView?>
}