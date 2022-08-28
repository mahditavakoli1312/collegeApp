package com.example.collegeapp.profile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_article_frProfile).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_profileFragment_to_myArticlesFragment,
                navController = findNavController()
            )
        }
        view.findViewById<Button>(R.id.btn_bookmark_frProfile).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_profileFragment_to_bookMarksFragment,
                navController = findNavController()
            )
        }
    }
}