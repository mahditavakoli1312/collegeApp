package com.example.collegeapp.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.R
import com.google.android.material.snackbar.Snackbar

class ShowArticleFragment : Fragment(R.layout.fragment_show_article) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageArticle: ImageView = view.findViewById(R.id.img_article_showArticleFragment)
        val writer: TextView = view.findViewById(R.id.tv_writerTimeArticleRecycler_showArticle)
        val imageBack: ImageView = view.findViewById(R.id.img_back_showArticleFragment)
        imageArticle.load(
            ResourcesCompat.getDrawable(
                view.resources,
                R.drawable.background_image,
                view.context.theme
            )
        ) {
            transformations(RoundedCornersTransformation(view.resources.getDimension(R.dimen.radius_8)))
        }

        writer.text =
            view.resources.getString(R.string.label_writer_time, "سبحان", "21 فروردین 1401")

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

        imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}