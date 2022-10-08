package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentSearchUserProfileBinding
import com.example.collegeapp.features.profile.ui.adapters.ViewPagerAdapterTabLayout
import com.example.collegeapp.features.search.ui.viewModel.SearchUserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchUserProfileFragment : Fragment() {
    private lateinit var binding: FragmentSearchUserProfileBinding
    private val fragmentList = listOf(ChildUserProfileSearchFragment())
    private val viewModel: SearchUserProfileViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search_user_profile,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            userProfileViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        val viewPager = binding.vpViewpagerSearchProfileFragment
        viewPager.adapter =
            ViewPagerAdapterTabLayout(fragmentList, lifecycle, childFragmentManager)
    }


}