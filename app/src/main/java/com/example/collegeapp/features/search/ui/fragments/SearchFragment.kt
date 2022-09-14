package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentSearchBinding

    companion object {
        private var currentState = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chipGroup = binding.cgSearchChipsSearchFragment

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(R.id.fcv_nestedFragmentHolder_searchFragment) as NavHostFragment

        navController = nestedNavHostFragment.navController

        chipGroup.setOnCheckedStateChangeListener { _, checkedId ->

            when {

                binding.cPostChipsGroupSearchFragment.id in checkedId -> {
                    navController.navigate(
                        R.id.childPostSearchFragment2
                    )
                    currentState = 0
                }

                binding.cTagsChipsGroupSearchFragment.id in checkedId -> {
                    navController.navigate(
                        R.id.childTagSearchFragment2
                    )
                    currentState = 1
                }

                binding.cUsersChipsGroupSearchFragment.id in checkedId -> {
                    navController.navigate(
                        R.id.childUserSearchFragment
                    )
                    currentState = 2
                }
            }
        }


    }
}