package com.example.collegeapp.features.home.ui

import androidx.lifecycle.*
import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.article.data.ArticleRepository
import com.example.collegeapp.features.home.data.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    articleRepository: ArticleRepository,
    private val homeRepository: HomeRepository
) : ViewModel() {
    /*   init {
           viewModelScope.launch(Dispatchers.IO) {
               Log.d("ListRemote", articleRepository.getSingleArticleRemote(1).toString())
           }
       }
   */
    var tagSearchContent = MutableLiveData<List<String>>()
    private var _article = MutableLiveData(articleRepository.getArticle())
    val article = _article
    private var _chipsList = MutableLiveData(homeRepository.getHomeTags())
    val chipsList = _chipsList

    val articleSearchTag: LiveData<List<ArticleEntity>> =
        Transformations.switchMap(tagSearchContent) {
            liveData<List<ArticleEntity>>(Dispatchers.IO) {
                emit(homeRepository.getArticleWithTag(it))
            }
        }

}