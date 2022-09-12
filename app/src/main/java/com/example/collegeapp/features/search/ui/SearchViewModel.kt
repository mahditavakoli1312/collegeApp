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

    private val _postList = MutableLiveData(searchRepository.getPosts())
    val postList = _postList

    private val _userList = MutableLiveData(searchRepository.getUsers())
    val userList = _userList

    private val _tagList = MutableLiveData(searchRepository.getTags())
    val tagList = _tagList
}