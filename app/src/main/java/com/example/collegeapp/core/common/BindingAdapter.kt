package com.example.collegeapp.core.common

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.collegeapp.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("imageUrl")
fun loadImg(imageView: ImageView, imageUrl: Int?) {
    if (imageUrl != null && imageUrl != 0) {
        imageView.load(
            imageUrl.let {
                ResourcesCompat.getDrawable(
                    imageView.resources,
                    it,
                    imageView.context.theme
                )
            }
        ) {
            error(R.drawable.ic_gallery)
            transformations(RoundedCornersTransformation(imageView.resources.getDimension(R.dimen.radius_8)))
        }
    }
}

@BindingAdapter("jalaliCalender")
fun jalaliCalender(textView: TextView, date: String?) {
    //String should be like this 2022-10-06T23:18:06.763Z
    if (date != null && date.isNotEmpty()) {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val text = date.split("T").get(0)
        val date = formatter.parse(text) as Date
        val converter = PersianDateConverter().calcSolarCalendar(date)
        textView.text =
            textView.text.toString() + " ${converter.date} ${converter.strMonth} ${converter.year}"

    }
}

