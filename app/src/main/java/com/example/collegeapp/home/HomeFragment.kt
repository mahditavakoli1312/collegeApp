package com.example.collegeapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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
        val rvArticle: RecyclerView = view.findViewById(R.id.rv_articles_homeFragment)
        val articleAdapter = ArticlesAdapter()
        rvArticle.adapter = articleAdapter
        articleAdapter.submitList(RecyclerDataTemp().articleList())

        view.findViewById<ImageView>(R.id.btn_newArticle_mainFragment).setOnClickListener {
            FragmentNavigationMethod.navigate(
                action = R.id.action_homeFragment_to_newArticleFragment,
                navController = findNavController()
            )
        }
    }
}