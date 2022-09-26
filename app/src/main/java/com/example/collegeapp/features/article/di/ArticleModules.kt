package com.example.collegeapp.features.article.di

import com.example.collegeapp.features.article.data.ArticleRepository
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleApi
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.dataSource.remote.impl.ArticleRemoteDataSourceImpl
import com.example.collegeapp.features.article.data.impl.ArticleRepositoryImpl
import com.example.collegeapp.features.profile.data.MyArticleRepository
import com.example.collegeapp.features.profile.data.impl.MyArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class ArticleModules {

    @Binds
    abstract fun bindArticle(articleRepository: ArticleRepositoryImpl): ArticleRepository

    @Binds
    abstract fun bindMyArticle(myArticleRepository: MyArticleRepositoryImpl): MyArticleRepository

    @Binds
    abstract fun bindArticleRemoteDataSource(impl: ArticleRemoteDataSourceImpl):
            ArticleRemoteDataSource

    companion object {
        @Provides
        fun provideSingleArticleApi(retrofit: Retrofit): ArticleApi =
            retrofit.create(ArticleApi::class.java)
    }

}