package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.R
import com.google.android.material.chip.Chip

class NewArticleFragment : Fragment(R.layout.fragment_new_article) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageArticle: ImageView = view.findViewById(R.id.img_article_newArticleFragment)
        val addTag: Chip = view.findViewById(R.id.c_addTag_newArticleFragment)
        val imageClose: ImageView = view.findViewById(R.id.img_close_newArticleFragment)

        imageArticle.load(
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.image_place_holder,
                view.context.theme
            )

        ) {
            transformations(RoundedCornersTransformation(view.resources.getDimension(R.dimen.radius_8)))
        }

        addTag.setOnClickListener {
            BottomSheetTagFragment().show(parentFragmentManager, "")
        }

        imageClose.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}