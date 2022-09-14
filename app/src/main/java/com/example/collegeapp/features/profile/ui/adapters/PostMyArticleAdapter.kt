package com.example.collegeapp.features.profile.ui.adapters

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigate
import com.example.collegeapp.databinding.ItemMyarticleProfileviewholderBinding
import com.example.collegeapp.features.home.ui.MainActivity
import com.example.collegeapp.features.search.data.entities.MyArticleEntity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class PostMyArticleAdapter :
    ListAdapter<MyArticleEntity, PostMyArticleAdapter.MyArticlePostHolder>(PostMyArticleDiffCallback) {

    class MyArticlePostHolder(val binding: ItemMyarticleProfileviewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(articleEntity: MyArticleEntity) {
            binding.apply {
                myArticle = articleEntity
                val chipsGroup: ChipGroup = binding.chipsGroupArticleRecyclerMyArticle
                val progressBar = pbProgressBarMyArticle
                val inProgress = tvInProgressMyArticles
                val currentProgress = 74
                progressBar.max = 100

                root.setOnClickListener {
                    val x =
                        MainActivity.globalMain?.findNavController(R.id.fcv_fragmentContainer_activityMain)
                            ?: root.findNavController()
                    Navigation.easyNavigate(
                        action = R.id.showArticleFragment,
                        navController = x
                    )
                }

                val tagsList = articleEntity.tag.split(",")
                chipsGroup.removeAllViews()
                tagsList.forEach {
                    chipsGroup.addView(Chip(root.context).apply {
                        text = it
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
                }

                if (articleEntity.inProgress) {
                    progressBar.visibility = View.VISIBLE
                    ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
                        .setDuration(2000)
                        .start()
                    inProgress.text = root.context.getString(R.string.label_in_progress)
                } else {
                    progressBar.visibility = View.INVISIBLE
                    inProgress.text = articleEntity.time
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
    }

}

object PostMyArticleDiffCallback : DiffUtil.ItemCallback<MyArticleEntity>() {
    override fun areItemsTheSame(oldItem: MyArticleEntity, newItem: MyArticleEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyArticleEntity, newItem: MyArticleEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}