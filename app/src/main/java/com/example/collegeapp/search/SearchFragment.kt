package com.example.collegeapp.search

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_post_frSearch).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_searchFragment_to_childPostSearchFragment,
                navController = findNavController()
            )
        }
        view.findViewById<Button>(R.id.btn_tags_frSearch).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_searchFragment_to_childTagSearchFragment,
                navController = findNavController()
            )
        }
        view.findViewById<Button>(R.id.btn_users_frSearch).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_searchFragment_to_childUserSearchFragment2,
                navController = findNavController()
            )
        }
    }
}