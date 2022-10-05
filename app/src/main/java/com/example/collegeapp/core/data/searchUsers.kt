package com.example.collegeapp.core.data

import android.content.Context
import com.example.collegeapp.R
import com.example.collegeapp.features.search.ui.model.SearchUserView

fun searchUserLists(context: Context): List<SearchUserView> {
    return listOf(
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_title_post_test)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_title_post_test)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        SearchUserView(
            nameUser = context.getString(R.string.label_mahdi)
        )
    )
}