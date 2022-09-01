package com.example.collegeapp.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.chip.Chip

class NewArticleFragment : Fragment(R.layout.fragment_new_article){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageArticle : ImageView = view.findViewById(R.id.img_article_newArticleFragment)
        val addTag : Chip = view.findViewById(R.id.c_addTag_newArticleFragment)

        imageArticle.load(view.resources.getDrawable(R.drawable.image_place_holder , view.context.theme)) {
            transformations(RoundedCornersTransformation(view.resources.getDimension(R.dimen.radius_8)))
        }

        addTag.setOnClickListener {
            BottomSheetTagFragment().show(this.parentFragmentManager , "")
        }


    }
}