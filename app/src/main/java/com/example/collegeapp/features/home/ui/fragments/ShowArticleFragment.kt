package com.example.collegeapp.features.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.R
import com.example.collegeapp.databinding.FragmentShowArticleBinding
import com.example.collegeapp.features.home.ui.ShowArticleViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowArticleFragment : Fragment() {
    companion object{
        const val articleID:String ="article_id"
    }
    private lateinit var binding : FragmentShowArticleBinding
    private val viewModel : ShowArticleViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_show_article , container , false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = this@ShowArticleFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            imgBackShowArticleFragment.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        view.findViewById<ImageView>(R.id.img_bookmark_showArticleFragment).setOnClickListener {
            val snackBar: Snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
            val viewSnack: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
            val customLayoutSnack = layoutInflater.inflate(R.layout.snackbar_internet_error, null)
            viewSnack.setBackgroundColor(view.resources.getColor(R.color.transparent100))
            viewSnack.addView(customLayoutSnack, 0)
            viewSnack.findViewById<TextView>(R.id.tv_okAction_snackLayout).visibility = View.GONE
            viewSnack.findViewById<TextView>(R.id.tv_cancelAction_snackLayout).visibility =
                View.GONE
            viewSnack.findViewById<ImageView>(R.id.img_icon_snackLayout).visibility = View.GONE
            viewSnack.findViewById<TextView>(R.id.tv_desc_SnackLayout).text =
                getString(R.string.label_added_article_to_bookmark)
            snackBar.show()
        }


    }
}