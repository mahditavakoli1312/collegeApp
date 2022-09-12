package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildSearchTagBinding
import com.example.collegeapp.features.search.ui.SearchViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildTagSearchFragment : Fragment() {
    private lateinit var binding: FragmentChildSearchTagBinding
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_child_search_tag, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chipGroup: ChipGroup = binding.cgTagSearchChildSearchTagFragment
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