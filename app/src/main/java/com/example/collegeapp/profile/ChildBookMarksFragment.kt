package com.example.collegeapp.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.search.adapters.SearchPostAdapter
import com.example.collegeapp.search.data.searchPostLists

class ChildBookMarksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child_book_marks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPostAdapter = SearchPostAdapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_postssearch_bookmark)
        recyclerView.adapter = searchPostAdapter
        searchPostAdapter.submitList(searchPostLists())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}