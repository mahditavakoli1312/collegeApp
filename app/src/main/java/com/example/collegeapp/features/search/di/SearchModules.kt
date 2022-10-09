package com.example.collegeapp.features.search.di


import com.example.collegeapp.features.search.data.dataSource.remote.SearchRemoteDataSource
import com.example.collegeapp.features.search.data.dataSource.remote.impl.SearchRemoteDataSourceImpl
import com.example.collegeapp.features.search.data.network.api.SearchApi
import com.example.collegeapp.features.search.data.repository.SearchRepository
import com.example.collegeapp.features.search.data.repository.impl.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchModules {

    @Binds
    abstract fun bindSearchRemoteDataSource(impl: SearchRemoteDataSourceImpl):
            SearchRemoteDataSource

    @Binds
    abstract fun bindRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

    companion object {
        @Provides
        fun provideSearchApi(retrofit: Retrofit): SearchApi =
            retrofit.create(SearchApi::class.java)
    }
}