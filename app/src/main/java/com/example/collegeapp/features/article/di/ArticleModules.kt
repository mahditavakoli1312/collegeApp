package com.example.collegeapp.features.article.di


import com.example.collegeapp.core.common.LocalDatabase
import com.example.collegeapp.features.article.data.dataSource.remote.ArticleRemoteDataSource
import com.example.collegeapp.features.article.data.dataSource.remote.impl.ArticleRemoteDataSourceImpl
import com.example.collegeapp.features.article.data.datasource.local.ArticleLocalDataSource
import com.example.collegeapp.features.article.data.datasource.local.impl.ArticleLocalDataSourceImpl
import com.example.collegeapp.features.article.data.dp.dao.ArticleDao
import com.example.collegeapp.features.article.data.dp.dao.ArticleDetailsDao
import com.example.collegeapp.features.article.data.dp.dao.BookmarkDao
import com.example.collegeapp.features.article.data.dp.dao.TagDao
import com.example.collegeapp.features.article.data.network.api.ArticleApi
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.data.repository.impl.ArticleRepositoryImpl
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
    abstract fun bindArticleReository(articleRepository: ArticleRepositoryImpl): ArticleRepository

    @Binds
    abstract fun bindMyArticleRepository(myArticleRepository: MyArticleRepositoryImpl): MyArticleRepository

    @Binds
    abstract fun bindArticleRemoteDataSource(articleRemoteDataSourceImpl: ArticleRemoteDataSourceImpl):
            ArticleRemoteDataSource

    @Binds
    abstract fun bindArticleLocalDataSource(articleLocalDataSourceImpl: ArticleLocalDataSourceImpl)
            : ArticleLocalDataSource

    companion object {
        @Provides
        fun provideArticleApi(retrofit: Retrofit): ArticleApi =
            retrofit.create(ArticleApi::class.java)

        @Provides
        fun provideArticleDetailsDao(database: LocalDatabase): ArticleDetailsDao =
            database.getArticleDetailsDao()

        @Provides
        fun provideBookmarkDao(database: LocalDatabase): BookmarkDao =
            database.getBookmarkDao()

        @Provides
        fun provideTagDao(database: LocalDatabase): TagDao =
            database.getTagDao()

        @Provides
        fun provideArticleDao(database: LocalDatabase): ArticleDao =
            database.getArticleDao()

        @Provides
        fun provideUserArticleDao(database: LocalDatabase): UserArticleDao =
            database.getUserArticleDataDao()

        @Provides
        fun provideUserArticleTagDao(database: LocalDatabase): UserArticleTagDao =
            database.getUserArticleTagDao()

    }

}