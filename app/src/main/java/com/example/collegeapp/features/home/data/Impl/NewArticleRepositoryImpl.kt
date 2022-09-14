package com.example.collegeapp.features.home.data.Impl

import com.example.collegeapp.features.home.data.NewArticleDataSource
import com.example.collegeapp.features.home.data.NewArticleRepository
import javax.inject.Inject

class NewArticleRepositoryImpl @Inject constructor(
    private val newArticleDataSource: NewArticleDataSource
) : NewArticleRepository