package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.features.search.ui.SearchViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildTagSearchFragment : Fragment(R.layout.fragment_child_search_tag) {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroup: ChipGroup = view.findViewById(R.id.cg_tagSearch_childSearchTagFragment)
        searchViewModel.tagList.value?.forEach {
            chipGroup.addView(
                Chip(
                    view.context,
                    null,
                    com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
                ).apply {
                    text = it
                    setChipBackgroundColorResource(R.color.white_10)
                    setTextColor(view.resources.getColor(R.color.primary_200))
                    setChipStrokeColorResource(R.color.transparent100)
                    chipStrokeWidth = view.resources.getDimension(R.dimen.stroke_1)
                    isClickable = true
                    isCheckable = false

                })
        }

    }


}