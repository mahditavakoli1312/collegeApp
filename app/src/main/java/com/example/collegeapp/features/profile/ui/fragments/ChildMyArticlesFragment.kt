package com.example.collegeapp.features.profile.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.features.profile.ui.ProfileViewModel
import com.example.collegeapp.features.profile.ui.adapters.PostMyArticleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildMyArticlesFragment : Fragment() {
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_child_my_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postMyArticleAdapter = PostMyArticleAdapter()


        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_postProfile_childMyArticles)
        recyclerView.adapter = postMyArticleAdapter
        postMyArticleAdapter.submitList(viewModel.myArticle.value)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


}