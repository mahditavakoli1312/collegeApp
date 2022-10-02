package com.example.collegeapp.core.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.example.collegeapp.R
import com.example.collegeapp.databinding.SnackbarLayoutBinding
import com.google.android.material.snackbar.Snackbar

class CustomSnackBar private constructor(
    val view: View,
    val requiredActivity: Activity,
    val descriptionText: String = view.resources.getString(R.string.label_internet_error),
    val color: Int = ResourcesCompat.getColor(
        view.resources,
        R.color.transparent100,
        view.context.theme
    ),
    val gravity: Int? = null,
    val snackBar_layout: Int = R.layout.snackbar_layout
) {
    data class Builder(

        var view: View,
        var requiredActivity: Activity,
        private var descriptionText: String = view.resources.getString(R.string.label_internet_error),
        private var color: Int = ResourcesCompat.getColor(
            view.resources,
            R.color.transparent100,
            view.context.theme
        ),
        private var gravity: Int? = null,
        private var snackbarLayout: Int = R.layout.snackbar_layout
    ) {

        fun setDescriptionText(descriptionText: String) =
            apply { this.descriptionText = descriptionText }

        fun setColor(color: Int) = apply { this.color = color }
        fun setGravity(gravity: Int) = apply { this.gravity = gravity }
        fun setSnackBarLayout(snackbarLayout: Int) = apply { this.snackbarLayout = snackbarLayout }

        fun build(): CustomSnackBar {
            return CustomSnackBar(
                view = view,
                requiredActivity = requiredActivity,
                descriptionText = descriptionText,
                color = color,
                gravity = gravity,
                snackBar_layout = snackbarLayout
            )
        }
    }

    @SuppressLint("RestrictedApi")
    fun showSnackBar() {
        val snackBar: Snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
        val viewSnack: Snackbar.SnackbarLayout = snackBar.view as Snackbar.SnackbarLayout
        val params = viewSnack.layoutParams as FrameLayout.LayoutParams
        if (gravity != null) {
            params.gravity = gravity
        }
        viewSnack.layoutParams = params
        val snackBarBinding: SnackbarLayoutBinding = DataBindingUtil.inflate(
            requiredActivity.layoutInflater,
            snackBar_layout,
            null,
            false
        )
        snackBarBinding.apply {
            tvOkActionSnackLayout.visibility = View.GONE
            tvCancelActionSnackLayout.visibility = View.GONE
            imgIconSnackLayout.visibility = View.GONE
            tvDescSnackLayout.text = descriptionText
        }
        viewSnack.setBackgroundColor(
            color
        )
        viewSnack.addView(snackBarBinding.root, 0)
        snackBar.show()
    }


}