package com.example.collegeapp.features.profile.di

import com.example.collegeapp.features.profile.data.repository.ProfileArticleRepository
import com.example.collegeapp.features.profile.data.repository.impl.ProfileArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProfileModules {
    @Binds
    abstract fun bindProfileRepository(impl: ProfileArticleRepositoryImpl): ProfileArticleRepository
}