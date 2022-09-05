package com.example.collegeapp.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.collegeapp.R
import com.example.collegeapp.profile.adapter.ViewPagerAdapterTabLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val tabTitleList = listOf("مقالات من", "بوکمارک ها")
    private val fragmentList = listOf(ChildMyArticlesFragment(), ChildBookMarksFragment())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.vp_viewpager_profileFragment)
        viewPager.adapter =
            ViewPagerAdapterTabLayout(fragmentList, lifecycle, childFragmentManager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tl_tabLayout_profileFragment)

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