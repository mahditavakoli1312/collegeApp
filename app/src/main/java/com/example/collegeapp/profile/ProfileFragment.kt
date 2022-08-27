package com.example.collegeapp.profile

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.collegeapp.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_article_frProfile).setOnClickListener{
            view.findViewById<TextView>(R.id.tv_info_frProfile).text = "articles"
        }
        view.findViewById<Button>(R.id.btn_bookmark_frProfile).setOnClickListener{
            view.findViewById<TextView>(R.id.tv_info_frProfile).text = "bookmarks"
        }
    }
}