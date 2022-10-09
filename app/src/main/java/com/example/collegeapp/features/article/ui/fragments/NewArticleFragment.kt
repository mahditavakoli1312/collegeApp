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
import com.example.collegeapp.core.data.ConstanceValue
import com.example.collegeapp.core.ui.CustomSnackBar
import com.example.collegeapp.databinding.FragmentNewArticleBinding
import com.example.collegeapp.features.article.ui.viewModels.NewArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewArticleFragment : Fragment() {

    private lateinit var binding: FragmentNewArticleBinding
    private val newArticleViewModel: NewArticleViewModel by viewModels()
    private var isTagSelected = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_new_article,
            container,
            false
        )
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = newArticleViewModel
            lifecycleOwner = viewLifecycleOwner
            cAddTagNewArticleFragment.setOnClickListener {
                BottomSheetTagFragment(true) { tagList ->
                    newArticleViewModel.tag.value = tagList[0]
                }.show(parentFragmentManager, "")
            }

            newArticleViewModel.tag.observe(viewLifecycleOwner) {
                cAddTagNewArticleFragment.text = it.title
                isTagSelected = true
            }

            imgCloseNewArticleFragment.setOnClickListener {
                findNavController().popBackStack()
            }

            btnShareArticleNewArticleFragment.setOnClickListener {
                newArticleViewModel.addArticle()
                progressShareArticleNewArticleFragment.visibility = View.VISIBLE
                btnShareArticleNewArticleFragment.visibility = View.GONE
            }

            newArticleViewModel.addArticleMessage.observe(viewLifecycleOwner) {
                progressShareArticleNewArticleFragment.visibility = View.GONE
                btnShareArticleNewArticleFragment.visibility = View.VISIBLE
                if (it.equals(ConstanceValue.SUCCESS)) {
                    CustomSnackBar.Builder(requireView(), requireActivity())
                        .setDescriptionText(getString(R.string.label_success_new_article))
                        .build().showSnackBar()
                    findNavController().popBackStack()
                } else {
                    CustomSnackBar.Builder(requireView(), requireActivity())
                        .setDescriptionText(it)
                        .build().showSnackBar()
                }
            }
        }
    }

}