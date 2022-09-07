package com.example.collegeapp.features.home.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.article.data.ArticleRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: ArticleRepositoryImpl
) : ViewModel() {
    private var _article = MutableLiveData(repository.getArticle())
    val article = _article
}