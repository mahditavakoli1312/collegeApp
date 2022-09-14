package com.example.collegeapp.features.search.data.Impl

import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.search.data.SearchDataSource
import com.example.collegeapp.features.search.data.SearchRepository
import com.example.collegeapp.features.search.data.entities.UserSearchEntity
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val dataSource: SearchDataSource
) : SearchRepository {
    override fun getPosts() = dataSource.getPosts()
    override fun getUsers() = dataSource.getUsers()
    override fun getTags() = dataSource.getTags()


    override fun getPostListBySearch(
        searchContent: String?,
    ): List<ArticleEntity> {
        return getPosts().filter { article ->
            article.title.contains(searchContent ?: "")
        }
    }

    override fun getUserListBySearch(
        searchContent: String?,
    ): List<UserSearchEntity> {
        return getUsers().filter { user ->
            user.nameUser.contains(searchContent ?: "")
        }
    }

    override fun getTagListBySearch(
        searchContent: String?,
    ): List<String> {
        return getTags().filter { tag ->
            tag.contains(searchContent ?: "")
        }
    }

}