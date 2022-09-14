package com.example.collegeapp.features.article.data

import com.example.collegeapp.features.article.data.impl.ArticleRepositoryImpl
import com.example.collegeapp.features.profile.data.MyArticleRepository
import com.example.collegeapp.features.profile.data.impl.MyArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ArticleModule {

    @Binds
    abstract fun bindArticle(articleRepository: ArticleRepositoryImpl): ArticleRepository

    @Binds
    abstract fun bindMyArticle(myArticleRepository: MyArticleRepositoryImpl): MyArticleRepository

}