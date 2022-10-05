package com.example.collegeapp.features.search.ui.model

import androidx.annotation.DrawableRes
import com.example.collegeapp.R
import com.example.collegeapp.features.search.data.model.response.SearchArticleResponse

//TODO : mahdi : need to optimization
data class SearchArticleView(
    val id: Int? = null,
    val title: String? = null,
    val content: String? = null,
    val readTimeMinutes: String? = null,
    val authorId: Int? = null,
    val authorFirstName: String? = null,
    val tags: List<SearchTagView> = listOf(),
    @DrawableRes
    val image: Int,
    val createdTime: String,
    val author: String,
)

fun SearchArticleResponse.toSearchArticleView() =
    SearchArticleView(
        id = id,
        title = title,
        content = content,
        readTimeMinutes = readTimeMinutes,
        createdTime = createdAt ?: "",
        authorId = authorId,
        author = "$authorFirstName $authorLastName",
        authorFirstName = authorFirstName,
        tags = tags.map { searchTagResponse ->
            searchTagResponse.toSearchTagView()
        },
        image = R.drawable.background_image,
    )