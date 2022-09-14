package com.example.collegeapp.features.bookmark.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildBookMarksBinding
import com.example.collegeapp.features.bookmark.ui.BookmarkViewModel
import com.example.collegeapp.features.search.ui.adapters.SearchPostAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildBookmarksFragment : Fragment() {
    private lateinit var binding: FragmentChildBookMarksBinding
    private val viewModel: BookmarkViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_child_book_marks, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPostAdapter = SearchPostAdapter()
        val recyclerView = binding.rvPostsSearchBookmarkFragment
        recyclerView.adapter = searchPostAdapter
        searchPostAdapter.submitList(viewModel.bookmark.value)

    }
}