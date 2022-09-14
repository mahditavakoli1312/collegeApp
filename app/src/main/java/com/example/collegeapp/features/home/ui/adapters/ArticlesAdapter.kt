package com.example.collegeapp.features.home.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigate
import com.example.collegeapp.databinding.ItemArticleHomerecyclerBinding
import com.example.collegeapp.features.article.data.ArticleEntity
import com.google.android.material.chip.Chip

class ArticlesAdapter :
    ListAdapter<ArticleEntity, ArticlesAdapter.ArticleViewHolder>(ArticleDiffCallBack) {

    class ArticleViewHolder(val binding: ItemArticleHomerecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: ArticleEntity) {
            with(binding) {
                articleBinding = article
                chipsGroupArticleRecyclerHomeFragment.removeAllViews()
                val tagsList = article.tag.split(",")
                binding.root.setOnClickListener {
                    Navigation.easyNavigate(
                        action = R.id.action_homeFragment_to_showArticleFragment,
                        navController = binding.root.findNavController()
                    )
                }

                tagsList.forEach {
                    chipsGroupArticleRecyclerHomeFragment.addView(Chip(binding.root.context).apply {
                        text = it
                        backgroundDrawable =
                            ResourcesCompat.getDrawable(
                                binding.root.resources,
                                R.drawable.tag_gray,
                                binding.root.context.theme
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
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleHomerecyclerBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }
}

object ArticleDiffCallBack : DiffUtil.ItemCallback<ArticleEntity>() {
    override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}