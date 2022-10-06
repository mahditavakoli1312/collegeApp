package com.example.collegeapp.features.bookmark.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ItemArticleBookmarkviewholderBinding
import com.example.collegeapp.features.bookmark.ui.model.BookmarkArticleView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class BookmarkRecyclerAdapter(
    private val onItemClick: (articleId: Int) -> Unit
) :
    ListAdapter<BookmarkArticleView, BookmarkRecyclerAdapter.SearchPostHolder>(
        SearchPostDiffCallback
    ) {

    class SearchPostHolder(val binding: ItemArticleBookmarkviewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val chipsGroup: ChipGroup =
            binding.chipsGroupArticleRecyclerHomeFragment

        fun bind(articleView: BookmarkArticleView) {
            binding.article = articleView
            binding.apply {

                chipsGroup.addView(Chip(itemView.context).apply {
                    text = articleView.tag.title
                    id = articleView.tag.id
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
        val binding = ItemArticleBookmarkviewholderBinding.inflate(inflater, parent, false)
        return SearchPostHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchPostHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
        holder.binding.root.setOnClickListener { onItemClick(post.id) }
    }

}

object SearchPostDiffCallback : DiffUtil.ItemCallback<BookmarkArticleView>() {
    override fun areItemsTheSame(
        oldItem: BookmarkArticleView,
        newItem: BookmarkArticleView
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: BookmarkArticleView,
        newItem: BookmarkArticleView
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}