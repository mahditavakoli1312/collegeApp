package com.example.collegeapp.features.article.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.TagView
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

    val tagSelected = MutableLiveData<List<TagView>>()

    private fun fetchTags() {
        viewModelScope.launch(Dispatchers.IO) {
            tagSelected.postValue(
                articleRepository.getTagSelected()
            ).let {
                when (val response = articleRepository.getTags()) {
                    is ResultWrapper.ApplicationError -> {
                        response.message.apply {
                            _fragmentStateMessage.postValue(ConstanceValue.FAILURE)
                        }
                        _tags.postValue(response.localData)
                    }
                    is ResultWrapper.Failure -> {
                        _fragmentStateMessage.postValue("${response.message} ${response.code}")
                        _tags.postValue(response.localData)
                    }
                    is ResultWrapper.Success ->
                        _tags.postValue(response.data)
                }
            }
        }
    }
}