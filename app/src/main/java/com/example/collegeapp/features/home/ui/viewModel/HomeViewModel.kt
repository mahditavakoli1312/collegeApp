package com.example.collegeapp.features.home.ui.viewModel

import androidx.lifecycle.*
import com.example.collegeapp.features.article.data.repository.ArticleRepository
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.example.collegeapp.features.article.ui.model.TagView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {

    var tagSearchContent = MutableLiveData<List<TagView>>()
    private var _article = liveData(Dispatchers.IO) {
        emitSource(articleRepository.getArticles())
    }
    val article = _article
    private var _chipsList = liveData(Dispatchers.IO) {
        emitSource(articleRepository.getTags())
    }
    val chipsList = _chipsList
    val articleSearchTag: LiveData<List<ArticleView>> =
        Transformations.switchMap(tagSearchContent) {
            liveData<List<ArticleView>?>(Dispatchers.IO) {
                emitSource(articleRepository.getArticleWithTags(it))
            }
        }
}