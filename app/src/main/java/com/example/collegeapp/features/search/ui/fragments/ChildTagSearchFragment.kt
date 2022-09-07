package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.collegeapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ChildTagSearchFragment : Fragment(R.layout.fragment_child_search_tag) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroup: ChipGroup = view.findViewById(R.id.cg_tagSearch_childSearchTagFragment)
        getFakeTagList().forEach {
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

    private fun getFakeTagList(): List<String> {
        return listOf(
            "تکنولوژِی",
            "نجوم",
            "مکانیک",
            "تکنولوژِی",
            "نجوم",
            "نانوتکنولوژی",
            "مکانیک",
            "تکنولوژِی",
            "نجوم",
            "نانوتکنولوژی",
            "مکانیک",
            "تکنولوژِی",
            "نجوم",
            "نانوتکنولوژی",
            "مکانیک",
            "تکنولوژِی",
            "نجوم",
            "نانوتکنولوژی",
            "مکانیک",
            "تکنولوژِی",
            "نجوم",
            "نانوتکنولوژی",
            "مکانیک",
        )
    }
}