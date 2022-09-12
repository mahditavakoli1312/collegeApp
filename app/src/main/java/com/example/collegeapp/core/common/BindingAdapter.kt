package com.example.collegeapp.core.common

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.R


@BindingAdapter("writer", "time")
fun setWriterAndTime(textView: TextView, writer: String, time: String) {
    textView.text = textView.resources.getString(
        R.string.label_writer_time,
        writer,
        time
    )
}

@BindingAdapter("imageUrl")
fun loadImg(imageView: ImageView, imageUrl: Int) {
    imageView.load(
        ResourcesCompat.getDrawable(
            imageView.resources,
            R.drawable.background_image,
            imageView.context.theme
        )
    ) {
        error(R.drawable.ic_gallery)
        transformations(RoundedCornersTransformation(imageView.resources.getDimension(R.dimen.radius_8)))
    }

}

