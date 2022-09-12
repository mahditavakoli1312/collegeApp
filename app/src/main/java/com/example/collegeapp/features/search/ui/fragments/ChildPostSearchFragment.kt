package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildSearchPostBinding
import com.example.collegeapp.features.search.ui.SearchViewModel
import com.example.collegeapp.features.search.ui.adapters.SearchPostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildPostSearchFragment : Fragment(R.layout.fragment_child_search_post) {

    private lateinit var binding : FragmentChildSearchPostBinding
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_child_search_post , container , false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPostAdapter = SearchPostAdapter()
        val recyclerView = binding.rvPostsSearchSearchFragment
        recyclerView.adapter = searchPostAdapter
        searchPostAdapter.submitList(searchViewModel.postList.value)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}