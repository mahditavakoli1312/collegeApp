package com.example.collegeapp.features.article.ui.viewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.R
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.AddArticleView
import com.example.collegeapp.features.article.ui.model.TagView
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    @ApplicationContext val context: Context
    //todo change context
) : ViewModel() {
    val title = MutableLiveData("")
    val description = MutableLiveData("")
    val tag = MutableLiveData<TagView>()
    val image = R.drawable.image_place_holder


    private val _addArticleMessage = MutableLiveData<String>()
    val addArticleMessage = _addArticleMessage


    fun addArticle() {
        viewModelScope.launch {
            val titleSize = title.value?.length
            val descSize = description.value?.length
            if (tag.value == null) {
                _addArticleMessage.postValue(context.getString(R.string.label_choose_one_tag))
            } else if (titleSize != null && titleSize < 3) {
                _addArticleMessage.postValue(context.getString(R.string.label_title_length))
            } else if (descSize != null && descSize < 50) {
                _addArticleMessage.postValue(context.getString(R.string.label_desc_length))
            } else {
                val response = articleRepository.addArticle(
                    AddArticleView(
                        title.value ?: "",
                        description.value ?: "",
                        tag.value?.id ?: 0
                    )
                )
                when (response) {
                    is ResultWrapper.ApplicationError -> _addArticleMessage.postValue(response.message)
                    is ResultWrapper.Failure -> _addArticleMessage.postValue(response.message)
                    is ResultWrapper.Success -> _addArticleMessage.postValue(ConstanceValue.SUCCESS)
                }
            }
        }
    }
}