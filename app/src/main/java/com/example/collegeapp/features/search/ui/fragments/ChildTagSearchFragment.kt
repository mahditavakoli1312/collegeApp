package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildSearchTagBinding
import com.example.collegeapp.features.search.ui.viewModel.SearchViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildTagSearchFragment : Fragment() {

    private lateinit var binding: FragmentChildSearchTagBinding
    private val searchViewModel: SearchViewModel by viewModels(
        ownerProducer = { requireParentFragment() },
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_child_search_tag,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            searchViewModel.tags.observe(viewLifecycleOwner) { tags ->
                cgTagSearchChildSearchTagFragment.removeAllViews()
                tags?.forEach { tag ->
                    cgTagSearchChildSearchTagFragment.addView(createChip(tag))
                }
            }
        }

    }

    private fun createChip(tagText: String): Chip {
        binding.apply {
            return Chip(
                root.context,
                null,
                com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
            ).apply {
                text = tagText
                setChipBackgroundColorResource(R.color.white_10)
                setTextColor(
                    ResourcesCompat.getColor(
                        root.resources,
                        R.color.primary_200,
                        root.context.theme
                    )
                )
                setChipStrokeColorResource(R.color.transparent100)
                chipStrokeWidth = root.resources.getDimension(R.dimen.stroke_1)
                isClickable = true
                isCheckable = false
            }
        }
    }
}