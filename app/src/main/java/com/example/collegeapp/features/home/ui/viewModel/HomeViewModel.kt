package com.example.collegeapp.features.home.ui.viewModel

import android.content.Context
import androidx.lifecycle.*
import com.example.collegeapp.R
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.article.ui.viewModels.UserFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    @ApplicationContext val context: Context
) : ViewModel() {
    init {
        fetchTags()
        fetchArticles()
    }

    private val _fragmentState = MutableLiveData(UserFragmentState.INITIAL_STATE)
    val fragmentState = _fragmentState

    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    var tagSearchContent = MutableLiveData<List<TagView>>()
    private var _article = MutableLiveData<List<ArticleView>?>(listOf())
    val article = _article
    private var _chipsList = MutableLiveData<List<TagView>?>(listOf())
    val chipsList = _chipsList
    val articleSearchTag: LiveData<List<ArticleView>> =
        Transformations.switchMap(tagSearchContent) {
            liveData<List<ArticleView>?>(Dispatchers.IO) {
                emit(articleRepository.getArticleWithTags(it))
            }
        }

    fun fetchArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = articleRepository.getArticles()) {
                is ResultWrapper.ApplicationError -> {
                    response.message.apply {
                        when (this) {
                            else -> {
                                //todo change context
                                _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                            }
                        }
                    }
                    _fragmentState.postValue(UserFragmentState.APP_ERROR)
                }
                is ResultWrapper.Failure -> {
                    _fragmentStateMessage.postValue("${response.message} ${response.code}")
                    _fragmentState.postValue(UserFragmentState.FAILURE)
                }
                is ResultWrapper.Success -> _article.postValue(response.data)
            }
        }
    }


    fun fetchTags() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = articleRepository.getTags()) {
                is ResultWrapper.ApplicationError -> {
                    response.message.apply {
                        when (this) {
                            else -> {
                                //todo change context
                                _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                            }
                        }
                    }
                    _fragmentState.postValue(UserFragmentState.APP_ERROR)
                }
                is ResultWrapper.Failure -> {
                    _fragmentStateMessage.postValue("${response.message} ${response.code}")
                    _fragmentState.postValue(UserFragmentState.FAILURE)
                }
                is ResultWrapper.Success -> _chipsList.postValue(response.data)
            }
        }
    }
}