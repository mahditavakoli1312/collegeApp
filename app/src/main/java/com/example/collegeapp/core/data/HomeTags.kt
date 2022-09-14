package com.example.collegeapp.core.data

import android.content.Context
import com.example.collegeapp.R

fun getHomeFakeTags(context: Context) = listOf(
    context.resources.getString(R.string.label_tag_fake_one),
    context.resources.getString(R.string.label_tag_fake_two),
    context.resources.getString(R.string.label_tag_fake_three),
    context.resources.getString(R.string.label_tag_fake_four),
    context.resources.getString(R.string.label_tag_fake_five),
)
