package com.example.collegeapp.features.article.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.core.ui.FragmentState
import com.example.collegeapp.databinding.FragmentShowArticleBinding
import com.example.collegeapp.features.article.ui.viewModels.ShowArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowArticleFragment : Fragment() {

    private lateinit var binding: FragmentShowArticleBinding
    private val showArticleViewModel: ShowArticleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_show_article,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showArticleViewModel.fragmentState.observe(viewLifecycleOwner) { fragmentState ->
            when (fragmentState) {
                FragmentState.SUCCESS -> {}
                FragmentState.FAILURE -> {

                    CustomSnackBar.Builder(
                        requiredActivity = requireActivity(),
                        view = view
                    )
                        .setDescriptionText(showArticleViewModel.fragmentStateMessage.value ?: "")
                        .build()
                        .showSnackBar()
                }
                FragmentState.APP_ERROR -> {
                    CustomSnackBar.Builder(
                        requiredActivity = requireActivity(),
                        view = view
                    )
                        .setDescriptionText(showArticleViewModel.fragmentStateMessage.value ?: "")
                        .build()
                        .showSnackBar()
                }
                FragmentState.INITIAL_STATE -> {}
                FragmentState.NO_REMOTE_NO_LOCAL -> {
                    CustomSnackBar.Builder(
                        requiredActivity = requireActivity(),
                        view = view
                    )
                        .setDescriptionText(showArticleViewModel.fragmentStateMessage.value ?: "")
                        .build()
                        .showSnackBar()
                    findNavController().popBackStack()
                }
                FragmentState.UNKNOWN_STATE -> {
                    CustomSnackBar.Builder(
                        requiredActivity = requireActivity(),
                        view = view
                    )
                        .setDescriptionText(showArticleViewModel.fragmentStateMessage.value ?: "")
                        .build()
                        .showSnackBar()
                    findNavController().popBackStack()
                }
            }

        }
        binding.apply {
            viewModel = this@ShowArticleFragment.showArticleViewModel
            lifecycleOwner = viewLifecycleOwner

            showArticleViewModel.createdTime.observe(viewLifecycleOwner) { createdTimeString ->
                createdTime = createdTimeString
            }

            showArticleViewModel.imageUrl.observe(viewLifecycleOwner) { imgUrl ->
                imageUrl = imgUrl
            }

            imgBackShowArticleFragment.setOnClickListener {
                findNavController().popBackStack()
            }

            imgBookmarkShowArticleFragment.setOnClickListener {
                if (showArticleViewModel.isBookmark.value == false) {
                    CustomSnackBar.Builder(
                        view = view,
                        requiredActivity = requireActivity()
                    )
                        .setDescriptionText(
                            view.resources.getString(R.string.label_added_article_to_bookmark)
                        )
                        .build()
                        .showSnackBar()
                }
                showArticleViewModel.bookmarkLogic()
            }

            showArticleViewModel.isBookmark.observe(viewLifecycleOwner) { isBookmarkk ->
                if (!isBookmarkk) {
                    imgBookmarkShowArticleFragment.setImageResource(R.drawable.ic_bookmark)
                } else {
                    imgBookmarkShowArticleFragment.setImageResource(R.drawable.ic_bookmarked)
                }

            }
        }
    }
}