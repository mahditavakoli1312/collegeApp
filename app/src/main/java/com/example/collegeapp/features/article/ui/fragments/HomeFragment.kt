package com.example.collegeapp.features.article.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.common.easyNavigate
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.databinding.FragmentHomeBinding
import com.example.collegeapp.features.article.ui.model.TagView
import com.example.collegeapp.features.article.ui.adapters.ArticlesAdapter
import com.example.collegeapp.features.article.ui.viewModels.HomeViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding

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
            srlRefreshArticleHomeFragment.setOnRefreshListener {
                srlRefreshArticleHomeFragment.isRefreshing = true
                homeViewModel.fetchArticles()
            }
            homeViewModel.article.observe(viewLifecycleOwner){
                srlRefreshArticleHomeFragment.isRefreshing = false
            }
            imgAddChipsHomeFragment.setOnClickListener {
                BottomSheetTagFragment(false) { tagList ->
                    tagList.map { it.isSelected = 1 }
                    homeViewModel.updateTagsSelected(tagList)
                }.show(parentFragmentManager, "")
            }

            homeViewModel.fragmentStateMessage.observe(viewLifecycleOwner) {
                CustomSnackBar.Builder(
                    requiredActivity = requireActivity(),
                    view = view
                )
                    .setDescriptionText(it)
                    .build()
                    .showSnackBar()
            }
        }
    }

    private fun createChipGroup() {
        binding.apply {
            homeViewModel.chipsList.observe(viewLifecycleOwner) {
                chipsFilterHomeFragment.removeAllViews()
                it?.forEach { tag ->
                    chipsFilterHomeFragment.addView(
                        createChip(tag)
                    )
                }
                hsvChipGroupHomeFragment.postDelayed({
                    hsvChipGroupHomeFragment.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                } , 0)

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
                if (chip.isChecked == 1)
                    isChecked = true
                checkedIcon = null
                setOnClickListener {
                    if (isChecked) {
                        chip.isChecked = 1
                        homeViewModel.updateTag(chip)
                    } else {
                        chip.isChecked = 0
                        homeViewModel.updateTag(chip)
                    }
                }
            }
        }
    }

}