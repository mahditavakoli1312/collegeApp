package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.features.search.ui.SearchViewModel
import com.example.collegeapp.features.search.ui.adapters.SearchUserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildUserSearchFragment : Fragment(R.layout.fragment_child_search_user) {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchUserAdapter = SearchUserAdapter()

        val recyclerView =
            view.findViewById<RecyclerView>(R.id.rv_usersSearch_childSearchPostFragment)
        recyclerView.adapter = searchUserAdapter
        searchUserAdapter.submitList(searchViewModel.userList.value)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}