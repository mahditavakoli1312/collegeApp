package com.example.collegeapp.features.search.data.network.api

import com.example.collegeapp.features.search.data.model.response.SearchBaseResponse
import com.example.collegeapp.features.search.data.model.response.SearchBodyRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SearchApi {
    @POST("search")
    suspend fun serach(@Body searchContent: SearchBodyRequest): Response<SearchBaseResponse>
}