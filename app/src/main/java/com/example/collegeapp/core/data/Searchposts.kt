package com.example.collegeapp.search.data

import android.content.Context
import com.example.collegeapp.R
import com.example.collegeapp.features.article.data.ArticleEntity

fun searchPostLists(context: Context): List<ArticleEntity> {
    return listOf(
        ArticleEntity(
            1,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)
        ),
        ArticleEntity(
            2,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            3,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            4,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            5,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            6,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            7,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),
        ArticleEntity(
            8,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),

        ArticleEntity(
            9,
            title = context.getString(R.string.label_fake_title_post).repeat(3),
            time = context.getString(R.string.label_time_fake),
            tag = context.getString(R.string.label_tag_fake),
            image = R.drawable.background_image,
            writer = context.getString(R.string.label_writer_fake)

        ),

        )
}