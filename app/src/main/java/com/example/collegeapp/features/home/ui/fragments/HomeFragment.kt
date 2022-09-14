package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentHomeBinding
import com.example.collegeapp.easyNavigate
import com.example.collegeapp.features.home.ui.HomeViewModel
import com.example.collegeapp.features.home.ui.adapters.ArticlesAdapter
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        val articleAdapter = ArticlesAdapter()
        articleAdapter.submitList(homeViewModel.article.value)

        binding.apply {

            viewModel = homeViewModel
            lifecycleOwner = viewLifecycleOwner

            rvArticlesHomeFragment.adapter = articleAdapter

            btnNewArticleMainFragment.setOnClickListener {
                Navigation.easyNavigate(
                    action = R.id.action_homeFragment_to_newArticleFragment,
                    navController = findNavController()
                )
            }

            homeViewModel.chipsList.observe(viewLifecycleOwner) {
                it.forEach {
                    chipsFilterHomeFragment.addView(
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

            imgAddChipsHomeFragment.setOnClickListener {
                BottomSheetTagFragment().show(parentFragmentManager, "")
            }
        }

    }
}