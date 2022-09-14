package com.example.collegeapp.features.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.article.data.ArticleRepository
import com.example.collegeapp.features.home.data.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val homeRepository: HomeRepository

) : ViewModel() {
    private var _article = MutableLiveData(articleRepository.getArticle())
    val article = _article

    private var _chipsList = MutableLiveData(homeRepository.getHomeTags())
    val chipsList = _chipsList
}