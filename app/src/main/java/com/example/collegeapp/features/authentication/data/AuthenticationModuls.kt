package com.example.collegeapp.features.authentication.data

import com.example.collegeapp.features.authentication.data.impl.AuthenticationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

abstract class AuthenticationModuls {

    @Binds
    abstract fun getAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository
}