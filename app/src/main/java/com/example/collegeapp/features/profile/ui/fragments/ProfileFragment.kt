package com.example.collegeapp.features.profile.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentProfileBinding
import com.example.collegeapp.features.bookmark.ui.fragments.ChildBookmarksFragment
import com.example.collegeapp.features.profile.ui.adapters.ViewPagerAdapterTabLayout
import com.example.collegeapp.features.profile.ui.viewModel.ProfileViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val fragmentList = listOf(ChildMyArticlesFragment(), ChildBookmarksFragment())
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_profile,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            profileViewModel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        val tabTitleList = listOf(
            requireContext().getString(R.string.label_myArticles),
            requireContext().getString(R.string.label_bookmark)
        )
        val viewPager = binding.vpViewpagerProfileFragment
        viewPager.adapter =
            ViewPagerAdapterTabLayout(fragmentList, lifecycle, childFragmentManager)
        val tabLayout = binding.tlTabLayoutProfileFragment
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, pos ->
            tab.text = tabTitleList[pos]
        }.attach()

        setupTabIconsForTwo(
            tabLayout = tabLayout,
            firstIcon = R.drawable.ic_myarticles,
            secondIcon = R.drawable.ic_bookmarks
        )

    }

    private fun setupTabIconsForTwo(tabLayout: TabLayout, firstIcon: Int, secondIcon: Int) {
        tabLayout.getTabAt(0)?.setIcon(firstIcon)
        tabLayout.getTabAt(1)?.setIcon(secondIcon)
    }

}