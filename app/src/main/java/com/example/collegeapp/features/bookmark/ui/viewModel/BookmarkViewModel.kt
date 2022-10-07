package com.example.collegeapp.features.bookmark.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeapp.features.bookmark.data.repository.BookmarkRepository
import com.example.collegeapp.features.bookmark.ui.model.BookmarkArticleView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {
    private val _bookmarks = MutableLiveData<List<BookmarkArticleView?>>()
    val bookmarks = _bookmarks

    init {
        fetchBookmarks()
    }

    fun fetchBookmarks() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = bookmarkRepository.getBookmarks()
            withContext(Dispatchers.Main) {
                _bookmarks.postValue(response.reversed())
            }
        }
    }
}