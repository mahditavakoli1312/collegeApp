package com.example.collegeapp.features.bookmark.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.features.bookmark.ui.BookmarkViewModel
import com.example.collegeapp.features.search.ui.adapters.SearchPostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildBookmarksFragment : Fragment() {
    private val viewModel: BookmarkViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_child_book_marks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPostAdapter = SearchPostAdapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_postsSearch_bookmarkFragment)
        recyclerView.adapter = searchPostAdapter
        searchPostAdapter.submitList(viewModel.bookmark.value)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}