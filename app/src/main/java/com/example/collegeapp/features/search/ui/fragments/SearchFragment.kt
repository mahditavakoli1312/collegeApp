package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.collegeapp.R
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.core.ui.FragmentState
import com.example.collegeapp.databinding.FragmentSearchBinding
import com.example.collegeapp.features.search.ui.adapters.SearchViewPagerAdapter
import com.example.collegeapp.features.search.ui.viewModel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()
    private var currentState = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleSearchViewPager()
        handleSearchChip()

        binding.apply {
            viewModel = searchViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        searchViewModel.fragmentState.observe(viewLifecycleOwner) { fragmentState ->
            when (fragmentState) {
                FragmentState.SUCCESS -> {}
                FragmentState.FAILURE -> {}
                FragmentState.APP_ERROR -> {}
                FragmentState.INITIAL_STATE -> {}
                FragmentState.NO_REMOTE_NO_LOCAL -> {}
                FragmentState.UNKNOWN_STATE -> {
                    CustomSnackBar.Builder(
                        requiredActivity = requireActivity(),
                        view = view
                    )
                        .setDescriptionText(searchViewModel.fragmentStateMessage.value ?: "")
                        .build()
                        .showSnackBar()
                }
            }

        }

        searchViewModel.searchVariable.observe(viewLifecycleOwner) { searchContent ->
            searchViewModel.fetchSearchData()
        }
    }


    private fun handleSearchViewPager() {
        binding.apply {
            vpNestedFragmentHolderSearchFragment.adapter =
                SearchViewPagerAdapter(childFragmentManager, lifecycle)
            vpNestedFragmentHolderSearchFragment.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> cPostChipsGroupSearchFragment.isChecked = true
                        1 -> cTagsChipsGroupSearchFragment.isChecked = true
                        2 -> cUsersChipsGroupSearchFragment.isChecked = true
                    }
                }

            })
        }
    }


    private fun handleSearchChip() {
        binding.apply {
            cgSearchChipsSearchFragment.setOnCheckedStateChangeListener { _, checkedId ->
                when {
                    binding.cPostChipsGroupSearchFragment.id in checkedId -> {
                        currentState = 0
                        vpNestedFragmentHolderSearchFragment.setCurrentItem(0, true)
                    }
                    binding.cTagsChipsGroupSearchFragment.id in checkedId -> {
                        currentState = 1
                        vpNestedFragmentHolderSearchFragment.setCurrentItem(1, true)
                    }
                    binding.cUsersChipsGroupSearchFragment.id in checkedId -> {
                        currentState = 2
                        vpNestedFragmentHolderSearchFragment.setCurrentItem(2, true)
                    }
                }
            }
        }
    }

}