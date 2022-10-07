package com.example.collegeapp.features.profile.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterTabLayout(
    private val fragmentLists: List<Fragment>,
    fragmentLifecycle: Lifecycle,
    fragmentManager: FragmentManager
) : FragmentStateAdapter(fragmentManager, fragmentLifecycle) {

    override fun getItemCount(): Int = fragmentLists.size

    override fun createFragment(position: Int): Fragment {
        return fragmentLists[position]
    }

}