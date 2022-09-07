package com.example.collegeapp.features.home.ui.adapters

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
import com.example.collegeapp.R
import com.example.collegeapp.easyNavigate
import com.example.collegeapp.features.article.data.ArticleEntity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ArticlesAdapter :
    ListAdapter<ArticleEntity, ArticlesAdapter.ArticleViewHolder>(ArticleDiffCallBack) {

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textTitle: TextView =
            itemView.findViewById(R.id.tv_titleArticleRecycler_homeFragment)
        private val textWriterTime: TextView =
            itemView.findViewById(R.id.tv_writerTimeArticleRecycler_homeFragment)
        private val imageArticle: ImageView =
            itemView.findViewById(R.id.img_articleRecycler_homeFragment)
        private val chipsGroup: ChipGroup =
            itemView.findViewById(R.id.chipsGroup_articleRecycler_homeFragment)

        fun bind(article: ArticleEntity) {
            chipsGroup.removeAllViews()
            itemView.setOnClickListener {
                Navigation.easyNavigate(
                    action = R.id.action_homeFragment_to_showArticleFragment,
                    navController = itemView.findNavController()
                )
            }
            textTitle.text = article.title
            textWriterTime.text = itemView.resources.getString(
                R.string.label_writer_time,
                article.writer,
                article.time
            )
            imageArticle.setImageResource(article.image)
            val tagsList = article.tag.split(",")

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
                    backgroundDrawable =
                        ResourcesCompat.getDrawable(
                            itemView.resources,
                            R.drawable.tag_gray,
                            itemView.context.theme
                        )
                    setTextColor(itemView.resources.getColor(R.color.primary_200))

                })
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article_homerecycler, parent, false)
        return ArticleViewHolder(view)
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