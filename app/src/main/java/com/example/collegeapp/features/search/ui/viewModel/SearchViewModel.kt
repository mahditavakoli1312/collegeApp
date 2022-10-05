package com.example.collegeapp.features.search.ui.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.R
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.ui.FragmentState
import com.example.collegeapp.features.search.data.repository.SearchRepository
import com.example.collegeapp.features.search.ui.model.SearchArticleView
import com.example.collegeapp.features.search.ui.model.SearchBodyView
import com.example.collegeapp.features.search.ui.model.SearchUserView
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

const val TAG = "google_kam_kherad"

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    @ApplicationContext val context: Context
) : ViewModel() {

    private val _fragmentState = MutableLiveData(FragmentState.INITIAL_STATE)
    val fragmentState = _fragmentState

    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    private val _searchVariable = MutableLiveData("")
    val searchVariable = _searchVariable

    private val _articles = MutableLiveData<List<SearchArticleView>?>()
    val articles = _articles

    private val _users = MutableLiveData<List<SearchUserView>>()
    val user = _users

    private val _tags = MutableLiveData<List<String>>()
    val tags = _tags

    fun fetchSearchData() {
        if (_searchVariable.value != "") {
            viewModelScope.launch(Dispatchers.IO) {
                val response =
                    searchRepository.search(SearchBodyView(searchText = _searchVariable.value))
                withContext(Dispatchers.Main) {
                    try {
                        when (response) {
                            is ResultWrapper.ApplicationError -> {
                                _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                                _fragmentState.postValue(FragmentState.APP_ERROR)

                            }
                            is ResultWrapper.Failure -> {
//                                _fragmentStateMessage.postValue("${_searchVariable.value} ${response.message} ${response.code}")
                                _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                                _fragmentState.postValue(FragmentState.FAILURE)

                            }
                            is ResultWrapper.Success -> {
                                _articles.postValue(response.data?.articles)
                                _tags.postValue(response.data?.tags?.map { searchTagView ->
                                    searchTagView.toString()
                                })
                                _users.postValue(response.data?.users)
                                _fragmentState.postValue(FragmentState.SUCCESS)

                            }
                        }
                    } catch (exception: Exception) {
                        _fragmentStateMessage.postValue(context.getString(R.string.label_unknown_error))
                        _fragmentState.postValue(FragmentState.UNKNOWN_STATE)

                    }
                }
            }
        } else {
            _articles.postValue(listOf())
            _tags.postValue(listOf())
            _users.postValue(listOf())
        }
    }
}

