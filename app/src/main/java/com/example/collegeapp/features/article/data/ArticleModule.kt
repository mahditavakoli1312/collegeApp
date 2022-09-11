package com.example.collegeapp.features.article.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ArticleModule {

    @Binds
    abstract fun bindArticle(articleRepository: ArticleRepository): ArticleRepositoryImpl
}