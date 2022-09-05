package com.example.collegeapp.profile.adapter

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.MainActivity
import com.example.collegeapp.R
import com.example.collegeapp.easyNavigate
import com.example.collegeapp.search.entities.MyArticleEntity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class PostMyArticleAdapter :

    ListAdapter<MyArticleEntity, PostMyArticleAdapter.MyArticlePostHolder>(PostMyArticleDiffCallback) {

    class MyArticlePostHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val textTitle: TextView =
            itemView.findViewById(R.id.tv_titleArticleRecycler_myArticle)
        private val imageArticle: ImageView =
            itemView.findViewById(R.id.img_articleRecycler_myArticle)
        private val chipsGroup: ChipGroup =
            itemView.findViewById(R.id.chipsGroup_articleRecycler_myArticle)

        private val progressBar = itemView.findViewById<ProgressBar>(R.id.pb_progressBar_myArticle)
        private val inProgress = itemView.findViewById<TextView>(R.id.tv_inProgress_myArticles)

        private var currentProgress = 74

        fun bind(articleEntity: MyArticleEntity) {
            progressBar.max = 100
            chipsGroup.removeAllViews()
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
            if (articleEntity.inProgress) {
                progressBar.visibility = View.VISIBLE
                ObjectAnimator.ofInt(progressBar, "progress", currentProgress).setDuration(2000)
                    .start()
                inProgress.text = "در حال انتشار"

            } else {
                progressBar.visibility = View.INVISIBLE
                inProgress.text = articleEntity.time
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyArticlePostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_myarticle_profileviewholder, parent, false)
        return MyArticlePostHolder(view)
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