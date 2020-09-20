package com.je2.jet2test.ui.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.je2.jet2test.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("app:loadImage")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .fitCenter()
            .into(view)
    }
}

@BindingAdapter("app:loadCircularImage")
fun loadCircularImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .circleCrop()
            .apply(RequestOptions().placeholder(R.drawable.user).error(R.drawable.user))
            .into(view)
    }
}

@BindingAdapter("app:setTimeDiff")
fun setTimeDiff(view: TextView, time: String) {
    var dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
    val createdTime = dateFormat.parse(time)
    val current = Calendar.getInstance().time
    val diff: Long = current.time - createdTime.time
    val minutes = diff / 60000
    val hours = minutes / 60
    val days = hours / 24

    view.text = if(days>0) "$days days" else if(hours>0) "$hours hours" else "$minutes minutes"

}


