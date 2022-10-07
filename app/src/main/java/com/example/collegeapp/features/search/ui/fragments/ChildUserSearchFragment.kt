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
import com.example.collegeapp.databinding.FragmentChildSearchUserBinding
import com.example.collegeapp.features.search.ui.adapters.SearchUserAdapter
import com.example.collegeapp.features.search.ui.viewModel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildUserSearchFragment : Fragment() {

    private lateinit var binding: FragmentChildSearchUserBinding
    private val searchViewModel: SearchViewModel by viewModels(
        ownerProducer = { requireParentFragment() },
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_child_search_user,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchUserAdapter = SearchUserAdapter { id, name ->
            val action =
                SearchFragmentDirections.actionSearchFragmentToSearchUserProfileFragment(
                    userId = id,
                    userName = name
                )
            parentFragment?.findNavController()
                ?.navigate(
                    action
                )
        }
        binding.apply {
            rvUsersSearchChildSearchPostFragment.adapter = searchUserAdapter
        }
        searchViewModel.user.observe(viewLifecycleOwner) { users ->
            searchUserAdapter.submitList(users)
        }
    }
}