package com.example.collegeapp.features.bookmark.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.bookmark.data.BookmarkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {
    private val _bookmark = MutableLiveData(bookmarkRepository.getBookmark())
    val bookmark = _bookmark
}