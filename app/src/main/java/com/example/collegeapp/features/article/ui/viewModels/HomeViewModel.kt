package com.example.collegeapp.features.article.ui.viewModels

import android.content.Context
import androidx.lifecycle.*
import com.example.collegeapp.R
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.ui.FragmentState
import com.example.collegeapp.features.article.data.model.entity.toTagEntity
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
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    @ApplicationContext val context: Context
) : ViewModel() {
    init {
        fetchTags()
        fetchArticles()
    }

    //TODO : Sobhan : manage _fragmentState and _fragmentStateMessage
    private val _fragmentState = MutableLiveData(FragmentState.INITIAL_STATE)
    val fragmentState = _fragmentState

    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    var tagSearchContent = MutableLiveData<List<TagView>>()
    private var _articles = MutableLiveData<List<ArticleView>?>(listOf())
    val article = _articles
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
                    _fragmentState.postValue(FragmentState.APP_ERROR)
                    _articles.postValue(response.localData)
                }
                is ResultWrapper.Failure -> {
                    _fragmentStateMessage.postValue("${response.message} ${response.code}")
                    _fragmentState.postValue(FragmentState.FAILURE)
                    _articles.postValue(response.localData)
                }
                is ResultWrapper.Success -> {
                    _articles.postValue(response.data)
                }
            }
        }
    }


    private fun fetchTags() {
        viewModelScope.launch(Dispatchers.IO) {
            articleRepository.getTagSelected()?.let { tagSelected ->
                _chipsList.postValue(tagSelected)
                val tagFilter = tagSelected.filter {
                    return@filter it.isChecked == 1
                }
                tagFilter.let {
                    if (it.isNotEmpty())
                        tagSearchContent.postValue(it)
                    else tagSearchContent.postValue(tagSelected)
                }

            }
        }
    }

    fun updateTagsSelected(tagSelectedList: List<TagView>) {
        viewModelScope.launch(Dispatchers.IO) {
            articleRepository.updateTags(tagSelectedList)
            withContext(Dispatchers.Main) {
                fetchTags()
            }
        }
    }

    fun updateTag(tag: TagView) {
        viewModelScope.launch(Dispatchers.IO) {
            articleRepository.updateTag(tag.toTagEntity())
            fetchTags()
        }
    }
}