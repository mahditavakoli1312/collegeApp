package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.easyNavigate
import com.example.collegeapp.features.home.ui.HomeViewModel
import com.example.collegeapp.features.home.ui.adapters.ArticlesAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvArticle: RecyclerView = view.findViewById(R.id.rv_articles_homeFragment)
        val articleAdapter = ArticlesAdapter()
        val chipsGroup: ChipGroup = view.findViewById(R.id.chips_filter_homeFragment)
        rvArticle.adapter = articleAdapter
        articleAdapter.submitList(homeViewModel.article.value)

        view.findViewById<ImageView>(R.id.btn_newArticle_mainFragment).setOnClickListener {
            Navigation.easyNavigate(
                action = R.id.action_homeFragment_to_newArticleFragment,
                navController = findNavController()
            )
        }

        homeViewModel.chipsList.observe(viewLifecycleOwner) {

            it.forEach {
                chipsGroup.addView(
                    Chip(
                        view.context,
                        null,
                        com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
                    ).apply {
                        text = it
                        setChipBackgroundColorResource(R.color.white_10)
                        setTextColor(view.resources.getColor(R.color.primary_200))
                        setChipStrokeColorResource(R.color.tophomechips_bordercolor_selector)
                        chipStrokeWidth = view.resources.getDimension(R.dimen.stroke_1)
                        isClickable = true
                        isCheckable = false
                        setOnClickListener {
                            isSelected = !isSelected
                        }
                    })
            }
        }


    }
}