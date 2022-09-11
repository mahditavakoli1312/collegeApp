package com.example.collegeapp.features.search.data

import com.example.collegeapp.features.search.data.Impl.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class SearchModuls {

    @Binds
    abstract fun getRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}