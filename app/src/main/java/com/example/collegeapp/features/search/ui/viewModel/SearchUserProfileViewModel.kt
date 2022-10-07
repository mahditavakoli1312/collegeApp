package com.example.collegeapp.features.search.ui.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.R
import com.example.collegeapp.core.networkUtils.ResultWrapper
import com.example.collegeapp.core.ui.FragmentState
import com.example.collegeapp.features.profile.data.repository.ProfileArticleRepository
import com.example.collegeapp.features.profile.ui.model.UserArticleDataView
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchUserProfileViewModel @Inject constructor(
    private val profileRepository: ProfileArticleRepository,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext val context: Context
) : ViewModel() {

    private val _userId = savedStateHandle.getLiveData<Int>("user_id")

    private val _nameUser = savedStateHandle.getLiveData<String>("user_name")
    val nameUser = _nameUser

    private var _userArticles = MutableLiveData<List<UserArticleDataView>?>()
    val userArticles = _userArticles

    private val _fragmentState = MutableLiveData(FragmentState.INITIAL_STATE)
    val fragmentState = _fragmentState

    private val _fragmentStateMessage = MutableLiveData<String>()
    val fragmentStateMessage = _fragmentStateMessage

    init {
        fetchUserArticles()
    }

    fun fetchUserArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            val response =
                profileRepository.getUserArticleByAuthorId(authorId = _userId.value ?: -1)
            withContext(Dispatchers.Main) {
                when (response) {
                    is ResultWrapper.ApplicationError -> {
                        try {
                            if (response.localData != null) {
                                response.message.apply {
                                    when (this) {
                                        else -> {
                                            _fragmentStateMessage.postValue(context.getString(R.string.label_appError))
                                        }
                                    }
                                }
                                _userArticles.postValue(response.localData.reversed())
                                _fragmentState.postValue(FragmentState.APP_ERROR)
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
                        _userArticles.postValue(response.localData?.reversed())
                        _fragmentState.postValue(FragmentState.FAILURE)
                    }
                    is ResultWrapper.Success -> {
                        _userArticles.postValue(response.data?.reversed())
                        _fragmentState.postValue(FragmentState.SUCCESS)
                    }
                }
            }

        }
    }

}