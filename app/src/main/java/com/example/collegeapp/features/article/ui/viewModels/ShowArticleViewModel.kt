package com.example.collegeapp.features.article.ui.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.fragments.ShowArticleFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _article =
        savedStateHandle.get<Int>(ShowArticleFragment.articleID)
            .let {
                liveData(Dispatchers.IO) {
                    emit(articleRepository.getArticleWithId(it ?: 8))
                }
            }
    val article = _article
}