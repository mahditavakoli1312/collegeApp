package com.example.collegeapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.collegeapp.MainActivity
import com.example.collegeapp.R

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_newArticle_mainFragment).setOnClickListener{
            MainActivity.globalMain?.replaceFragmentWithAddToBackStack(NewArticleFragment())
        }
        view.findViewById<Button>(R.id.btn_showArticle_mainFragment).setOnClickListener{
            MainActivity.globalMain?.replaceFragmentWithAddToBackStack(ShowArticleFragment())
        }
    }
}