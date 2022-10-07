package com.example.collegeapp.features.bookmark.di

import com.example.collegeapp.features.bookmark.data.dataSource.local.BookmarkLocalDataSource
import com.example.collegeapp.features.bookmark.data.dataSource.local.impl.BookmarkLocalDataSourceImpl
import com.example.collegeapp.features.bookmark.data.repository.BookmarkRepository
import com.example.collegeapp.features.bookmark.data.repository.impl.BookmarkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BookmarkModule {

    @Binds
    abstract fun bindBookmarkRepository(impl: BookmarkRepositoryImpl): BookmarkRepository

    @Binds
    abstract fun bindBookmarkLocalDataSource(impl: BookmarkLocalDataSourceImpl): BookmarkLocalDataSource


}