package com.example.collegeapp.search

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

        val chipGroup = view.findViewById<ChipGroup>(R.id.cg_searchChips_searchfragment)
        val checkedChipId = chipGroup.checkedChipId
        val checkedChipIds = chipGroup.checkedChipIds

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.fcv_nestedFragmentHolder_searchFragment) as NavHostFragment

        navController = nestedNavHostFragment.navController

        chipGroup.setOnCheckedStateChangeListener { group, checkedId ->
//            Log.d("chippp12", checkedId.toString())

            when {

                R.id.c_post_chipsgroup_searchfragment in checkedId -> {
                    navController.navigate(
                        R.id.childPostSearchFragment2
                    )
                    currentState = 0
//                    Log.d("chippp", checkedId.toString())
                }

                R.id.c_tags_chipsgroup_searchfragment in checkedId -> {
                    navController.navigate(
                        R.id.childTagSearchFragment2
                    )
                    currentState = 1
//                    Log.d("chippp", checkedId.toString())
                }

                R.id.c_users_chipsgroup_searchfragment in checkedId -> {
                    navController.navigate(
                        R.id.childUserSearchFragment
                    )
                    currentState = 2
//                    Log.d("chippp", checkedId.toString())
                }
            }
        }


    }
}