package com.example.collegeapp.features.article.data.module

import com.example.collegeapp.features.article.data.datasource.remote.ArticleApi
import com.example.collegeapp.features.article.data.datasource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.datasource.remote.impl.ArticleRemoteDataSourceImpl
import com.example.collegeapp.features.article.data.repository.impl.ArticleRepositoryImpl
import com.example.collegeapp.features.article.data.repository.ArticleRepository
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
abstract class ArticleModule {

    @Binds
    abstract fun bindArticle(articleRepository: ArticleRepositoryImpl): ArticleRepository

    @Binds
    abstract fun bindMyArticle(myArticleRepository: MyArticleRepositoryImpl): MyArticleRepository

    @Binds
    abstract fun bindArticleRemoteDataSource(articleRemoteDataSourceImpl: ArticleRemoteDataSourceImpl) : ArticleRemoteDataSource

    companion object {
        @Provides
        fun provideSingleArticleApi(retrofit: Retrofit): ArticleApi =
            retrofit.create(ArticleApi::class.java)
    }

}