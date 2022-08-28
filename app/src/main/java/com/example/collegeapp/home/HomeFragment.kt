package com.example.collegeapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.FragmentNavigationMethod
import com.example.collegeapp.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_newArticle_mainFragment).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_homeFragment_to_newArticleFragment,
                navController = findNavController()
            )
        }
        view.findViewById<Button>(R.id.btn_showArticle_mainFragment).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_homeFragment_to_showArticleFragment,
                navController = findNavController()
            )
        }
    }
}