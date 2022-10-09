package com.example.collegeapp.features.article.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ItemArticleHomerecyclerBinding
import com.example.collegeapp.features.article.ui.model.ArticleView
import com.google.android.material.chip.Chip

class ArticlesAdapter(private val onItemClick: (articleId: Int) -> Unit) :
    ListAdapter<ArticleView, ArticlesAdapter.ArticleViewHolder>(ArticleDiffCallBack) {

    class ArticleViewHolder(val binding: ItemArticleHomerecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: ArticleView) {
            with(binding) {
                articleBinding = article
                chipsGroupArticleRecyclerHomeFragment.removeAllViews()
                chipsGroupArticleRecyclerHomeFragment.addView(Chip(binding.root.context).apply {
                    text = article.tag.title
                    id = article.tag.id
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemArticleHomerecyclerBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
        holder.binding.root.setOnClickListener { onItemClick(article.id) }
    }
}

object ArticleDiffCallBack : DiffUtil.ItemCallback<ArticleView>() {
    override fun areItemsTheSame(oldItem: ArticleView, newItem: ArticleView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleView, newItem: ArticleView): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}
