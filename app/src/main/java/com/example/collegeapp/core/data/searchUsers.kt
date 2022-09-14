package com.example.collegeapp.core.data

import android.content.Context
import com.example.collegeapp.R
import com.example.collegeapp.features.search.data.entities.UserSearchEntity

fun searchUserLists(context: Context): List<UserSearchEntity> {
    return listOf(
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_title_post_test)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_title_post_test)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_fake_writer_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        ),
        UserSearchEntity(
            nameUser = context.getString(R.string.label_mahdi)
        )
    )
}