package com.example.collegeapp.profile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.collegeapp.profile.ChildBookMarksFragment
import com.example.collegeapp.profile.ChildMyArticlesFragment


class ViewPagerAdapterTabLayout(

    private val fragmentLists: List<Fragment>,
    fragmentLifecycle: Lifecycle,
    fragmentManager: FragmentManager
) : FragmentStateAdapter(fragmentManager, fragmentLifecycle) {

    override fun getItemCount(): Int = fragmentLists.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChildMyArticlesFragment()
            1 -> ChildBookMarksFragment()
            else -> ChildMyArticlesFragment()

        }
    }


}