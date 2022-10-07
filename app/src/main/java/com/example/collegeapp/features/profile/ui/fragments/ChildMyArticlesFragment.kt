package com.example.collegeapp.features.profile.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildMyArticlesBinding
import com.example.collegeapp.features.profile.ui.adapters.PostMyArticleAdapter
import com.example.collegeapp.features.profile.ui.viewModel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildMyArticlesFragment : Fragment() {

    private lateinit var binding: FragmentChildMyArticlesBinding
    private val viewModel: ProfileViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_child_my_articles,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postMyArticleAdapter = PostMyArticleAdapter { articleId ->
            val action =
                ProfileFragmentDirections.actionProfileFragmentToShowArticleFragment(articleID = articleId)
            parentFragment?.findNavController()
                ?.navigate(
                    action
                )
        }
        val recyclerView = binding.rvPostProfileChildMyArticles
        recyclerView.adapter = postMyArticleAdapter
        viewModel.userArticles.observe(viewLifecycleOwner) { userArticles ->
            postMyArticleAdapter.submitList(userArticles)
        }
    }
}