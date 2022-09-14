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

    private val _searchVariable = MutableLiveData("")
    val searchVariable = _searchVariable


    fun getPostListBySearch(): List<ArticleEntity>? {
        return searchRepository.getPostListBySearch(_searchVariable.value)
    }

    fun getUserListBySearch(): List<UserSearchEntity>? {
        return searchRepository.getUserListBySearch(searchVariable.value)
    }

    fun getTagListBySearch(): List<String>? {
        return searchRepository.getTagListBySearch(searchVariable.value)
    }
}
