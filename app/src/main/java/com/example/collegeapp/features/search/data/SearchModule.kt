package com.example.collegeapp.features.search.data

import com.example.collegeapp.features.search.data.impl.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class SearchModule {
    @Binds
    abstract fun bindRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}