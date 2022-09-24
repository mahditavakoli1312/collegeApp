package com.example.collegeapp.features.home.data

import com.example.collegeapp.features.home.data.impl.HomeRepositoryImpl
import com.example.collegeapp.features.home.data.impl.ShowArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun bindShowArticleRepository(showArticleRepositoryImpl: ShowArticleRepositoryImpl): ShowArticleRepository

}