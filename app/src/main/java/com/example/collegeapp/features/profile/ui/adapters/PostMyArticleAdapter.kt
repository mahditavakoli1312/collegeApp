package com.example.collegeapp.features.profile.ui.adapters

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ItemMyarticleProfileviewholderBinding
import com.example.collegeapp.features.profile.ui.model.UserArticleDataView
import com.google.android.material.chip.Chip

class PostMyArticleAdapter(
    private val onItemClick: (articleId: Int) -> Unit
) :
    ListAdapter<UserArticleDataView, PostMyArticleAdapter.MyArticlePostHolder>(
        PostMyArticleDiffCallback
    ) {

    class MyArticlePostHolder(val binding: ItemMyarticleProfileviewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userArticle: UserArticleDataView) {
            binding.apply {
                myArticle = userArticle
                val progressBar = pbProgressBarMyArticle
                val inProgress = tvInProgressMyArticles
                val currentProgress = 74
                progressBar.max = 100
                chipsGroupArticleRecyclerMyArticle.removeAllViews()

                chipsGroupArticleRecyclerMyArticle.addView(Chip(root.context).apply {
                    text = userArticle.tag?.name
                    id = userArticle.tag?.id ?: -1
                    backgroundDrawable = ResourcesCompat.getDrawable(
                        root.resources,
                        R.drawable.tag_gray,
                        root.context.theme
                    )
                    setTextColor(
                        ResourcesCompat.getColor(
                            root.resources,
                            R.color.primary_200,
                            root.context.theme
                        )
                    )
                })
                if (false) {
                    progressBar.visibility = View.VISIBLE
                    ObjectAnimator.ofInt(progressBar, "progress", currentProgress).setDuration(2000)
                        .start()
                    inProgress.text = "در حال انتشار"

                } else {
                    progressBar.visibility = View.INVISIBLE
                    inProgress.text = userArticle.createdAt
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyArticlePostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMyarticleProfileviewholderBinding.inflate(inflater, parent, false)
        return MyArticlePostHolder(binding)
    }

    override fun onBindViewHolder(holder: MyArticlePostHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
        holder.binding.root.setOnClickListener { onItemClick(post.id ?: -1) }
    }

}

object PostMyArticleDiffCallback : DiffUtil.ItemCallback<UserArticleDataView>() {
    override fun areItemsTheSame(
        oldItem: UserArticleDataView,
        newItem: UserArticleDataView
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: UserArticleDataView,
        newItem: UserArticleDataView
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}