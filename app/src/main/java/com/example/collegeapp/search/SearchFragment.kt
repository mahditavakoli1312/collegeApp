package com.example.collegeapp.search

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.collegeapp.R
import com.example.fragment_test.FragmentTransaction

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_post_frSearch).setOnClickListener{
            FragmentTransaction.replaceFragment(ChildPostSearchFragment(),this.childFragmentManager , R.id.cv_searchFragment)
        }
        view.findViewById<Button>(R.id.btn_tags_frSearch).setOnClickListener{
            FragmentTransaction.replaceFragment(ChildTagSearchFragment(),this.childFragmentManager , R.id.cv_searchFragment)
        }
        view.findViewById<Button>(R.id.btn_users_frSearch).setOnClickListener{
            FragmentTransaction.replaceFragment(ChildUserSearchFragment(),this.childFragmentManager , R.id.cv_searchFragment)
        }
    }
}