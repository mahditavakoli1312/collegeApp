package com.example.collegeapp.features.search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ItemPostSerarchviewholderBinding
import com.example.collegeapp.features.search.ui.model.SearchArticleView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SearchPostAdapter(
    private val onItemClick: (articleId: Int) -> Unit
) :
    ListAdapter<SearchArticleView, SearchPostAdapter.SearchPostHolder>(SearchPostDiffCallback) {

    class SearchPostHolder(val binding: ItemPostSerarchviewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val chipsGroup: ChipGroup =
            binding.chipsGroupArticleRecyclerHomeFragment

        fun bind(articleView: SearchArticleView) {
            binding.article = articleView
            binding.apply {

                chipsGroup.addView(Chip(itemView.context).apply {
                    text = articleView.tags.first().name
                    id = articleView.tags.first().id ?: -1
                    backgroundDrawable = ResourcesCompat.getDrawable(
                        itemView.resources,
                        R.drawable.tag_gray,
                        itemView.context.theme
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostSerarchviewholderBinding.inflate(inflater, parent, false)
        return SearchPostHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchPostHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
        holder.binding.root.setOnClickListener { onItemClick(post.id ?: -1) }
    }

}

object SearchPostDiffCallback : DiffUtil.ItemCallback<SearchArticleView>() {
    override fun areItemsTheSame(oldItem: SearchArticleView, newItem: SearchArticleView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: SearchArticleView,
        newItem: SearchArticleView
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}