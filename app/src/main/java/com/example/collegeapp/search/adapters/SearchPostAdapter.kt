package com.example.collegeapp.search.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.MainActivity
import com.example.collegeapp.R
import com.example.collegeapp.search.entities.ArticleEntity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SearchPostAdapter :
    ListAdapter<ArticleEntity, SearchPostAdapter.SearchPostHolder>(SearchPostDiffCallback) {

    class SearchPostHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val textTitle: TextView =
            itemView.findViewById(R.id.tv_titleArticleRecycler_homeFragment)
        private val textWriterTime: TextView =
            itemView.findViewById(R.id.tv_writerTimeArticleRecycler_homeFragment)
        private val imageArticle: ImageView =
            itemView.findViewById(R.id.img_articleRecycler_homeFragment)
        private val chipsGroup: ChipGroup =
            itemView.findViewById(R.id.chipsGroup_articleRecycler_homeFragment)

        fun bind(articleEntity: ArticleEntity) {
            itemView.setOnClickListener {
                val x =
                    MainActivity.globalMain?.findNavController(R.id.fcv_fragmentContainer_activityMain)
                        ?: itemView.findNavController()

                FragmentNavigationMethod.navigate(
                    action = R.id.showArticleFragment,
                    navController = x
                )
            }
            textTitle.text = articleEntity.title
            textWriterTime.text = itemView.resources.getString(
                R.string.label_writer_time,
                articleEntity.writer,
                articleEntity.time
            )
            imageArticle.setImageResource(articleEntity.image)
            val tagsList = articleEntity.tag.split(",")

            imageArticle.load(itemView.resources.getDrawable(R.drawable.background_image)) {
                transformations(RoundedCornersTransformation(itemView.resources.getDimension(R.dimen.radius_8)))
            }
            tagsList.forEach {
                chipsGroup.addView(Chip(itemView.context).apply {
                    text = it
                    backgroundDrawable = itemView.resources.getDrawable(R.drawable.tag_gray)
                    setTextColor(itemView.resources.getColor(R.color.primary_200))

                })
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_serarchviewholder, parent, false)
        return SearchPostHolder(view)
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