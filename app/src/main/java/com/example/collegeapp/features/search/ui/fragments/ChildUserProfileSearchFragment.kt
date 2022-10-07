package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildUserProfileSearchBinding
import com.example.collegeapp.features.profile.ui.adapters.PostMyArticleAdapter
import com.example.collegeapp.features.search.ui.viewModel.SearchUserProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildUserProfileSearchFragment : Fragment() {

    private lateinit var binding: FragmentChildUserProfileSearchBinding
    private val viewModel: SearchUserProfileViewModel by viewModels(
        ownerProducer = { requireParentFragment() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_child_user_profile_search,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val postMyArticleAdapter = PostMyArticleAdapter { articleId ->
            val action =
                SearchUserProfileFragmentDirections.actionSearchUserProfileFragmentToShowArticleFragment(
                    articleID = articleId
                )
            parentFragment?.findNavController()
                ?.navigate(
                    action
                )
        }
        val recyclerView = binding.rvPostProfileChildSearchProfile
        recyclerView.adapter = postMyArticleAdapter
        viewModel.userArticles.observe(viewLifecycleOwner) { userArticles ->
            postMyArticleAdapter.submitList(userArticles)
        }
    }


}