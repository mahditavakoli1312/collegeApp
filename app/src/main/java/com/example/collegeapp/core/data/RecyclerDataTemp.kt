package com.example.collegeapp.core.data

import android.content.Context
import com.example.collegeapp.R
import com.example.collegeapp.features.article.data.ArticleEntity
import javax.inject.Inject

class RecyclerDataTemp @Inject constructor() {
    fun articleList(context: Context): List<ArticleEntity> {
        val resultList = mutableListOf<ArticleEntity>()
        resultList.add(
            ArticleEntity(
                1 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                2 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                3 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                4 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                5 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                6 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                7 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                8 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                9 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                10 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        resultList.add(
            ArticleEntity(
                11 ,
                context.getString(R.string.label_fake_title_post),
                R.drawable.background_image,
                context.getString(R.string.label_time_fake),
                context.getString(R.string.label_writer_fake),
                context.getString(R.string.label_tag_fake)
            )
        )
        return resultList.toList()
    }
}