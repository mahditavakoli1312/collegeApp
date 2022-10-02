package com.example.collegeapp.features.article.ui.viewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.R
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShowArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext val context: Context
) : ViewModel() {


    private val _articleId = savedStateHandle.getLiveData<Int>("articleID")

    /*for test ServerError
    private val _articleId = MutableLiveData<Int>(100)*/
    private val _articleDetail = MutableLiveData(
        ArticleView(
            id = 0,
            title = "",
            content = "",
            image = R.drawable.background_image,
            createdTime = "",
            author = "",
            tag = TagView(id = 0, "")
        )
    )
    val article = _articleDetail

    private val _fragmentState = MutableLiveData(UserFragmentState.INITIAL_STATE)
    val fragmentState = _fragmentState

    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    init {
        fetchArticleDetails()
    }

    fun fetchArticleDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = articleRepository.getArticleDetails(_articleId.value!!)
            withContext(Dispatchers.Main) {
                when (response) {
                    is ResultWrapper.ApplicationError -> {
                        response.message.apply {
                            when (this) {
                                else -> {
                                    //todo change context to provide module
                                    _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                                }
                            }
                        }
                        _fragmentState.postValue(UserFragmentState.APPERROR)
                        _articleDetail.postValue(response.localData)
                    }
                    is ResultWrapper.Failure -> {
                        _fragmentStateMessage.postValue("${response.message} ${response.code}")
                        _fragmentState.postValue(UserFragmentState.FAILURE)
                        _articleDetail.postValue(response.localData)
                    }
                    is ResultWrapper.Success -> {
                        _articleDetail.postValue(response.data)
                        _fragmentState.postValue(UserFragmentState.SUCCESS)
                    }
                }
            }

        }
    }
}

enum class UserFragmentState {
    SUCCESS,
    FAILURE,
    APPERROR,
    INITIAL_STATE
}