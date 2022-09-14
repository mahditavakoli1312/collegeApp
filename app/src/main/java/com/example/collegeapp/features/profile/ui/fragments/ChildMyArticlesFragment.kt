package com.example.collegeapp.features.profile.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildMyArticlesBinding
import com.example.collegeapp.features.profile.ui.ProfileViewModel
import com.example.collegeapp.features.profile.ui.adapters.PostMyArticleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildMyArticlesFragment : Fragment() {
    private lateinit var binding: FragmentChildMyArticlesBinding
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_child_my_articles, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postMyArticleAdapter = PostMyArticleAdapter()


        val recyclerView = binding.rvPostProfileChildMyArticles
        recyclerView.adapter = postMyArticleAdapter
        postMyArticleAdapter.submitList(viewModel.myArticle.value)

    }


}