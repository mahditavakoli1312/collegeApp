package com.example.collegeapp.features.search.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.search.data.SearchRepository
import com.example.collegeapp.features.search.data.entities.UserSearchEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _searchVariable = MutableLiveData<String>("")
    val searchVariable = _searchVariable

    private val _postList = MutableLiveData(searchRepository.getPosts())
    private val _userList = MutableLiveData(searchRepository.getUsers())
    private val _tagList = MutableLiveData(searchRepository.getTags())

    fun getPostListBySearch(searchContent: String): List<ArticleEntity>? {
        return _postList.value?.filter { article ->
            article.title.contains(searchContent)
        }
    }

    fun getUserListBySearch(searchContent: String): List<UserSearchEntity>? {
        return _userList.value?.filter { user ->
            user.nameUser.contains(searchContent)
        }
    }

    fun getTagListBySearch(searchContent: String): List<String>? {
        return _tagList.value?.filter { tag ->
            tag.contains(searchContent)
        }
    }
}
