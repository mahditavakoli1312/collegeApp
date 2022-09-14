package com.example.collegeapp.features.search.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildSearchUserBinding
import com.example.collegeapp.features.search.ui.SearchViewModel
import com.example.collegeapp.features.search.ui.adapters.SearchUserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildUserSearchFragment : Fragment() {

    private lateinit var binding: FragmentChildSearchUserBinding
    private val searchViewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_child_search_user, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchUserAdapter = SearchUserAdapter()
        binding.apply {
            rvUsersSearchChildSearchPostFragment.adapter = searchUserAdapter
            rvUsersSearchChildSearchPostFragment.layoutManager =
                LinearLayoutManager(requireContext())
        }

        searchViewModel.searchVariable.observe(viewLifecycleOwner) {
            searchUserAdapter.submitList(searchViewModel.getUserListBySearch())
        }

    }
}