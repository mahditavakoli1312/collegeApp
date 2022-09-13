package com.example.collegeapp.features.search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.ItemPostSerarchviewholderBinding
import com.example.collegeapp.easyNavigate
import com.example.collegeapp.features.article.data.ArticleEntity
import com.example.collegeapp.features.home.ui.MainActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SearchPostAdapter :
    ListAdapter<ArticleEntity, SearchPostAdapter.SearchPostHolder>(SearchPostDiffCallback) {

    class SearchPostHolder(private val binding: ItemPostSerarchviewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val chipsGroup: ChipGroup =
            binding.chipsGroupArticleRecyclerHomeFragment

        fun bind(articleEntity: ArticleEntity) {
            binding.article = articleEntity
            binding.root.setOnClickListener {
                val x =
                    MainActivity.globalMain?.findNavController(R.id.fcv_fragmentContainer_activityMain)
                        ?: itemView.findNavController()

                Navigation.easyNavigate(
                    action = R.id.showArticleFragment,
                    navController = x
                )
            }
            val tagsList = articleEntity.tag.split(",")
            tagsList.forEach {
                chipsGroup.addView(Chip(itemView.context).apply {
                    text = it
                    backgroundDrawable = ResourcesCompat.getDrawable(
                        itemView.resources,
                        R.drawable.tag_gray,
                        itemView.context.theme
                    )
                    setTextColor(itemView.resources.getColor(R.color.primary_200))

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
    }


}


object SearchPostDiffCallback : DiffUtil.ItemCallback<ArticleEntity>() {
    override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}