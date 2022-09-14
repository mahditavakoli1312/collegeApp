package com.example.collegeapp.features.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewArticleViewModel @Inject constructor(

) : ViewModel(){
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val image = R.drawable.image_place_holder
}