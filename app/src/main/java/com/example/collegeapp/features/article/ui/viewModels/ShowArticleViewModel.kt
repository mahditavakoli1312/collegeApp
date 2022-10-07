package com.example.collegeapp.features.article.ui.viewModels

import android.content.Context
import androidx.lifecycle.*
import com.example.collegeapp.R
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.ui.FragmentState
import com.example.collegeapp.features.article.data.model.entity.toBookmarkEntity
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.bookmark.ui.model.BookmarkView
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val TAG = "GOOGLE_KAM_KHERAD"

@HiltViewModel
class ShowArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext val context: Context
) : ViewModel() {


    private val _articleId = savedStateHandle.getLiveData<Int>("articleID")
    val createdTime = MutableLiveData<String>()
    val imageUrl = MutableLiveData<Int>()

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

    private val _fragmentState = MutableLiveData(FragmentState.INITIAL_STATE)
    val fragmentState = _fragmentState

    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    private val _bookmark = MutableLiveData<Boolean>()
    val isBookmark: LiveData<Boolean> = _bookmark

    init {
        fetchArticleDetails()
        bookmarksIsExist()
    }

    fun fetchArticleDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = articleRepository.getArticleDetails(_articleId.value ?: -1)
            withContext(Dispatchers.Main) {
                when (response) {
                    is ResultWrapper.ApplicationError -> {
                        try {
                            if (response.localData != null) {

                                response.message.apply {
                                    when (this) {
                                        else -> {
                                            //todo change context to provide module
                                            _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                                        }
                                    }
                                }
                                _fragmentState.postValue(FragmentState.APP_ERROR)
                                _articleDetail.postValue(response.localData)
                                createdTime.postValue(response.localData.createdTime)
                                imageUrl.postValue(response.localData.image)
                            } else {
                                _fragmentStateMessage.postValue(context.getString(R.string.label_no_remote_no_local))
                                _fragmentState.postValue(FragmentState.NO_REMOTE_NO_LOCAL)
                            }
                        } catch (exception: Exception) {
                            _fragmentStateMessage.postValue(context.getString(R.string.label_unknown_error))
                            _fragmentState.postValue(FragmentState.UNKNOWN_STATE)
                        }
                    }
                    is ResultWrapper.Failure -> {
                        _fragmentStateMessage.postValue("${response.message} ${response.code}")
                        _fragmentState.postValue(FragmentState.FAILURE)
                        _articleDetail.postValue(response.localData)
                        createdTime.postValue(response.localData?.createdTime)
                        imageUrl.postValue(response.localData?.image)
                    }
                    is ResultWrapper.Success -> {
                        _articleDetail.postValue(response.data)
                        createdTime.postValue(response.data?.createdTime)
                        imageUrl.postValue(response.data?.image)
                        _fragmentState.postValue(FragmentState.SUCCESS)

                    }
                }
            }

        }
    }


    private fun addToBookmarks() {
        viewModelScope.launch(Dispatchers.IO) {
            articleRepository.insertBookmark(
                BookmarkView(
                    serverId = _articleId.value ?: -1
                ).toBookmarkEntity()
            )
        }

    }


    private fun removeFromBookmarks() {
        viewModelScope.launch(Dispatchers.IO) {
            articleRepository.removeBookmarkByServerId(
                serverId = _articleId.value ?: -1
            )
        }
    }


    private fun bookmarksIsExist() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _bookmark.postValue(
                    articleRepository.bookmarksIsExist(
                        serverId = _articleId.value ?: -1
                    )
                )
            }
        }
    }


    fun bookmarkLogic() {
        if (_bookmark.value == true) {
            removeFromBookmarks()
            _bookmark.postValue(false)
        } else {
            addToBookmarks()
            _bookmark.postValue(true)
        }
    }
}
