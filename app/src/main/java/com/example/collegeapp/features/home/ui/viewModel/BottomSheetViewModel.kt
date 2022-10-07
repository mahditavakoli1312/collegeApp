package com.example.collegeapp.features.home.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.R
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.article.ui.viewModels.UserFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    init {
        fetchTags()
    }
    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    private val _tags = MutableLiveData<List<TagView>?>()
    val tag = _tags

    private fun fetchTags() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = articleRepository.getTags()) {
                is ResultWrapper.ApplicationError -> {
                    response.message.apply {
                        when (this) {
                            else -> {
                                //TODO : change context
                                _fragmentStateMessage.postValue(ConstanceValue.FAILURE)
                            }
                        }
                    }
                    _tags.postValue(response.localData)
                }
                is ResultWrapper.Failure -> {
                    _fragmentStateMessage.postValue("${response.message} ${response.code}")
                    _tags.postValue(response.localData)
                }
                is ResultWrapper.Success -> _tags.postValue(response.data)
            }
        }
    }
}