package com.example.collegeapp.search.data

import android.content.Context
import com.example.collegeapp.R
import com.example.collegeapp.features.search.data.entities.ArticleEntity

fun searchPostLists(context: Context): List<ArticleEntity> {
    return listOf(
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)
        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),

        ArticleEntity(
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),

        )
}