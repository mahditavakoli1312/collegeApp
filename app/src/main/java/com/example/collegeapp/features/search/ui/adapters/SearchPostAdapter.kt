package com.example.collegeapp.features.search.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.features.home.ui.MainActivity
import com.example.collegeapp.R
import com.example.collegeapp.easyNavigate
import com.example.collegeapp.features.search.data.entities.ArticleEntity
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

                Navigation.easyNavigate(
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

            imageArticle.load(
                ResourcesCompat.getDrawable(
                    itemView.resources,
                    R.drawable.background_image,
                    itemView.context.theme
                )
            ) {
                transformations(RoundedCornersTransformation(itemView.resources.getDimension(R.dimen.radius_8)))
            }
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