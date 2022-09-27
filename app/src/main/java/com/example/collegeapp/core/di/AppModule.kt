package com.example.collegeapp.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.collegeapp.core.common.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context) : LocalDatabase{
        return Room.databaseBuilder(context , LocalDatabase::class.java , "helium").build()
    }
}