package com.example.collegeapp.features.profile.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.features.profile.data.MyArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val myArticleRepository: MyArticleRepository
) : ViewModel(){
    private var _myArticle = MutableLiveData(myArticleRepository.getArticle())
    val myArticle = _myArticle
}