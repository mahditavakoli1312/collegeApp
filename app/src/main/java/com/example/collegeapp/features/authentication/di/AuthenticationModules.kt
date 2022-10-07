package com.example.collegeapp.features.authentication.di

import com.example.collegeapp.features.authentication.data.datasource.local.AuthenticationLocalDataSource
import com.example.collegeapp.features.authentication.data.datasource.local.impl.AuthenticationLocalDataSourceImpl
import com.example.collegeapp.features.authentication.data.datasource.remote.AuthenticationRemoteDataSource
import com.example.collegeapp.features.authentication.data.datasource.remote.impl.AuthenticationRemoteDataSourceImpl
import com.example.collegeapp.features.authentication.data.network.api.AuthenticationApi
import com.example.collegeapp.features.authentication.data.repository.AuthenticationRepository
import com.example.collegeapp.features.authentication.data.repository.impl.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)

abstract class AuthenticationModules {

    @Binds
    abstract fun bindAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository

    @Binds
    abstract fun bindAuthenticationRemoteDataSource(
        authenticationRemoteDataSourceImpl: AuthenticationRemoteDataSourceImpl
    ): AuthenticationRemoteDataSource

    @Binds
    abstract fun bindAuthenticationLocalDataSource(authenticationLocalDataSourceImpl: AuthenticationLocalDataSourceImpl)
            : AuthenticationLocalDataSource


    companion object {
        @Provides
        fun provideAuthenticationApi(retrofit: Retrofit): AuthenticationApi {
            return retrofit.create(AuthenticationApi::class.java)
        }
    }
}