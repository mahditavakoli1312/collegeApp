package com.example.collegeapp.features.bookmark.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
abstract class BookmarkModule {

    @Binds
    abstract fun getBookmark(bookmarkRepositoryImpl: BookmarkRepositoryImpl) : BookmarkRepository
}