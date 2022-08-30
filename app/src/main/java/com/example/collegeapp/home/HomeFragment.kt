package com.example.collegeapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toolbar
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class HomeFragment : Fragment() {
    val chipsList = listOf("نانو" , "تکنولوزی" , "خیام", "سعدی" , "روانشناسی")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvArticle: RecyclerView = view.findViewById(R.id.rv_articles_homeFragment)
        val articleAdapter = ArticlesAdapter()
        val chipsGroup :ChipGroup = view.findViewById(R.id.chips_filter_homeFragment)
        rvArticle.adapter = articleAdapter
        articleAdapter.submitList(RecyclerDataTemp().articleList())

        view.findViewById<ImageView>(R.id.btn_newArticle_mainFragment).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_homeFragment_to_newArticleFragment,
                navController = findNavController()
            )
        }

        chipsList.forEach {
            chipsGroup.addView(Chip(view.context , null , com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice).apply {
                text = it
                backgroundDrawable = view.resources.getDrawable(R.drawable.tag_gray , view.context.theme)
                setTextColor(view.resources.getColor(R.color.primary_200))
                setChipStrokeColorResource(R.color.tophomechips_bordercolor_selector)
                chipStrokeWidth = view.resources.getDimension(R.dimen.stroke_1)
                //Todo Stroke Color should be handle in this method
            })
        }

    }
}