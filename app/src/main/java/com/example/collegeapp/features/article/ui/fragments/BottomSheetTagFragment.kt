package com.example.collegeapp.features.article.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentBottomSheetTagsBinding
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.article.ui.viewModels.BottomSheetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomSheetTagFragment(
    private val singleSelect: Boolean, val tagChooses: (List<TagView>) -> Unit
) : BottomSheetDialogFragment() {
    private val tagListSelected: MutableList<TagView> = mutableListOf()
    lateinit var binding: FragmentBottomSheetTagsBinding
    private val bottomSheetViewModel: BottomSheetViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_bottom_sheet_tags,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            imgCloseBottomSheetTag.setOnClickListener { dismiss() }
            btnChooseTags.setOnClickListener {
                tagChooses(tagListSelected.toList())
                dismiss()
            }

            bottomSheetViewModel.tag.observe(viewLifecycleOwner) {
                it?.forEach { chip ->
                    chipsTagsBottomSheetTag.addView(
                        createChip(chip)
                    )
                }
            }
            chipsTagsBottomSheetTag.isSingleSelection = singleSelect

            bottomSheetViewModel.tagSelected.observe(viewLifecycleOwner) {
                if (!singleSelect) {
                    tagListSelected.clear()
                    tagListSelected.addAll(it ?: listOf())
                }
            }
        }


    }

    private fun createChip(chip: TagView): Chip {
        binding.apply {
            return Chip(
                root.context,
                null,
                com.google.android.material.R.style.Widget_MaterialComponents_Chip_Filter
            ).apply {
                text = chip.title
                setChipBackgroundColorResource(R.color.white_10)
                setTextColor(
                    ResourcesCompat.getColor(
                        root.resources,
                        R.color.primary_200,
                        root.context.theme
                    )
                )
                id = chip.id
                setChipStrokeColorResource(R.color.top_home_chips_bordercolor_selector)
                chipStrokeWidth = root.resources.getDimension(R.dimen.stroke_1)
                isClickable = true
                isCheckable = true
                isChecked = tagListSelected.any { chip.id == it.id }
                checkedIcon = null
                setOnClickListener {
                    if (isChecked) {
                        tagListSelected.add(chip)
                    } else {
                        tagListSelected.remove(chip)
                    }
                }
            }
        }
    }

}