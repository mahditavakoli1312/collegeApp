package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.collegeapp.R
import com.google.android.material.chip.ChipGroup

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var navController: NavController

    companion object {
        private var currentState = 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroup = view.findViewById<ChipGroup>(R.id.cg_searchChips_searchFragment)
        val checkedChipId = chipGroup.checkedChipId
        val checkedChipIds = chipGroup.checkedChipIds

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.fcv_nestedFragmentHolder_searchFragment) as NavHostFragment

        navController = nestedNavHostFragment.navController

        chipGroup.setOnCheckedStateChangeListener { group, checkedId ->

            when {

                R.id.c_post_chipsGroup_searchFragment in checkedId -> {
                    navController.navigate(
                        R.id.childPostSearchFragment2
                    )
                    currentState = 0
                }

                R.id.c_tags_chipsGroup_searchFragment in checkedId -> {
                    navController.navigate(
                        R.id.childTagSearchFragment2
                    )
                    currentState = 1
                }

                R.id.c_users_chipsGroup_searchFragment in checkedId -> {
                    navController.navigate(
                        R.id.childUserSearchFragment
                    )
                    currentState = 2
                }
            }
        }


    }
}