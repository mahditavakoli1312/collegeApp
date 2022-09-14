package com.example.collegeapp.features.home.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.home.data.Impl.ShowArticleRepositoryImpl
import com.example.collegeapp.features.home.ui.fragments.ShowArticleFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowArticleViewModel @Inject constructor(
    private val showArticleRepositoryImpl: ShowArticleRepositoryImpl,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _article =
        savedStateHandle.getLiveData<Int>(ShowArticleFragment.articleID)
            .let {
                showArticleRepositoryImpl.getArticleData(it.value ?: 1)
            }
    val article = _article
}