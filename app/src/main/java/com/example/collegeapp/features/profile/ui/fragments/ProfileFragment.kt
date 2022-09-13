package com.example.collegeapp.features.profile.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentProfileBinding
import com.example.collegeapp.features.bookmark.ui.fragments.ChildBookmarksFragment
import com.example.collegeapp.features.profile.ui.adapters.ViewPagerAdapterTabLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding
    private val tabTitleList = listOf("مقالات من", "بوکمارک ها")
    private val fragmentList = listOf(ChildMyArticlesFragment(), ChildBookmarksFragment())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_profile , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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