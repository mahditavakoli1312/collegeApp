package com.example.collegeapp.features.search.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.collegeapp.features.search.ui.fragments.ChildPostSearchFragment
import com.example.collegeapp.features.search.ui.fragments.ChildTagSearchFragment
import com.example.collegeapp.features.search.ui.fragments.ChildUserSearchFragment

class SearchViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChildPostSearchFragment()
            1 -> ChildTagSearchFragment()
            else -> ChildUserSearchFragment()
        }
    }
}