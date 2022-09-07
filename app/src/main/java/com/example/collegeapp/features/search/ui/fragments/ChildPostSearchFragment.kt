package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.features.search.ui.adapters.SearchPostAdapter
import com.example.collegeapp.search.data.searchPostLists

class ChildPostSearchFragment : Fragment(R.layout.fragment_child_search_post) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_child_search_post, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPostAdapter = SearchPostAdapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_postsSearch_searchFragment)
        recyclerView.adapter = searchPostAdapter
        searchPostAdapter.submitList(searchPostLists(requireContext()))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}