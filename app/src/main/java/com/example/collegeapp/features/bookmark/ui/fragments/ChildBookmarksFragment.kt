package com.example.collegeapp.features.bookmark.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentChildBookMarksBinding
import com.example.collegeapp.features.bookmark.ui.adapter.BookmarkRecyclerAdapter
import com.example.collegeapp.features.bookmark.ui.viewModel.BookmarkViewModel
import com.example.collegeapp.features.profile.ui.fragments.ProfileFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChildBookmarksFragment : Fragment() {

    private lateinit var binding: FragmentChildBookMarksBinding
    private val viewModel: BookmarkViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_child_book_marks,
                container,
                false
            )
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchBookmarks()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPostAdapter = BookmarkRecyclerAdapter { articleId ->
            val action =
                ProfileFragmentDirections.actionProfileFragmentToShowArticleFragment(articleID = articleId)
            parentFragment?.findNavController()
                ?.navigate(
                    action
                )
        }
        val recyclerView = binding.rvPostsSearchBookmarkFragment
        recyclerView.adapter = searchPostAdapter

        viewModel.bookmarks.observe(viewLifecycleOwner) { bookmarks ->
            searchPostAdapter.submitList(bookmarks)

        }
    }
}