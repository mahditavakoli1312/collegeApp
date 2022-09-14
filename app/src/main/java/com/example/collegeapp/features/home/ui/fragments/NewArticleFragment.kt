package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentNewArticleBinding
import com.example.collegeapp.features.home.ui.NewArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewArticleFragment : Fragment(R.layout.fragment_new_article) {
    private lateinit var binding: FragmentNewArticleBinding
    private val viewModel: NewArticleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_article, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = this@NewArticleFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            cAddTagNewArticleFragment.setOnClickListener {
                BottomSheetTagFragment().show(parentFragmentManager, "")
            }

            imgCloseNewArticleFragment.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}