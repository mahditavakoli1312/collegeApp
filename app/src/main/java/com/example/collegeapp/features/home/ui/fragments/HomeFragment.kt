package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigate
import com.example.collegeapp.databinding.FragmentHomeBinding
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.home.ui.adapters.ArticlesAdapter
import com.example.collegeapp.features.home.ui.viewModel.HomeViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
    private val tagSelectedList = mutableListOf<TagView>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val articleAdapter = ArticlesAdapter { articleId ->
            val action =
                HomeFragmentDirections.actionHomeFragmentToShowArticleFragment(articleID = articleId)
            findNavController().navigate(
                action
            )
        }
        homeViewModel.article.observe(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
        createChipGroup()
        binding.apply {
            viewModel = homeViewModel
            lifecycleOwner = viewLifecycleOwner
            rvArticlesHomeFragment.adapter = articleAdapter
            btnNewArticleMainFragment.setOnClickListener {
                Navigation.easyNavigate(
                    action = HomeFragmentDirections.actionHomeFragmentToNewArticleFragment(),
                    navController = findNavController()
                )
            }
            homeViewModel.articleSearchTag.observe(viewLifecycleOwner) {
                articleAdapter.submitList(it)
            }
            imgAddChipsHomeFragment.setOnClickListener {
                BottomSheetTagFragment(false , ){tagList ->
                    //todo select list
                }.show(parentFragmentManager, "")
            }
        }
    }

    private fun createChipGroup() {
        binding.apply {
            homeViewModel.chipsList.observe(viewLifecycleOwner) {
                it?.forEach { tag ->
                    chipsFilterHomeFragment.addView(
                        createChip(tag)
                    )
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
                checkedIcon = null
                setOnClickListener {
                    if (isChecked)
                        tagSelectedList.add(chip)
                    else tagSelectedList.remove(chip)
                    homeViewModel.tagSearchContent.postValue(tagSelectedList)
                }
            }
        }
    }

}