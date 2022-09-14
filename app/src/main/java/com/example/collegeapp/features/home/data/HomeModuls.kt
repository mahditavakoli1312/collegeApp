package com.example.collegeapp.features.home.data

import com.example.collegeapp.features.home.data.Impl.HomeRepositoryImpl
import com.example.collegeapp.features.home.data.Impl.ShowArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModuls {

    @Binds
    abstract fun getHomeRepo(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun getShowRepo(showArticleRepositoryImpl: ShowArticleRepositoryImpl): ShowArticleRepository

}