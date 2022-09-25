package com.example.collegeapp.core.di

import com.example.collegeapp.core.data.URLs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModules {

    @Provides
    @Named("base_url")
    fun provideBaseURL(): String = URLs.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(@Named("base_url") baseurl: String): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}