package com.example.collegeapp.adapters

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
import com.example.collegeapp.Entities.ArticleEntity
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SearchPostAdapter :
    ListAdapter<ArticleEntity, SearchPostAdapter.SearchPostHolder>(SearchPostDiffCallback) {

    /* ViewHolder for Flower, takes in the inflated view and the onClick behavior. */
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

        /* Bind flower name and image. */
        fun bind(articleEntity: ArticleEntity) {
            itemView.setOnClickListener {
                FragmentNavigationMethod.navigate(
                    action = R.id.action_homeFragment_to_showArticleFragment,
                    navController = itemView.findNavController()
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

    /* Creates and inflates view and return FlowerViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post_serarchviewholder, parent, false)
        return SearchPostHolder(view)
    }

    /* Gets current flower and uses it to bind view. */
    override fun onBindViewHolder(holder: SearchPostHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)

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