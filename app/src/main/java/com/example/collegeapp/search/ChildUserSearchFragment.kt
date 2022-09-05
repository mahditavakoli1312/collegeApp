package com.example.collegeapp.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.search.adapters.SearchUserAdapter
import com.example.collegeapp.search.data.searchUserLists

class ChildUserSearchFragment : Fragment(R.layout.fragment_child_search_user) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchUserAdapter = SearchUserAdapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_userssearch_childSearchPostFragment)
        recyclerView.adapter = searchUserAdapter
        searchUserAdapter.submitList(searchUserLists())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}