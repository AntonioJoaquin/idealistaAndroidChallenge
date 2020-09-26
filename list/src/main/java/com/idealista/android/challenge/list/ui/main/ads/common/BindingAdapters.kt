package com.idealista.android.challenge.list.ui.main.ads.common

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.idealista.android.challenge.list.R

@BindingAdapter("setExpandTextVisibility")
fun TextView.setExpandTextVisibility(spannableText: String?) {
    if (!spannableText.isNullOrBlank()) {
        text = spannableText

        if (lineCount > DEFAULT_LINES_SPANNABLE_TEXT) {
            text = context.resources.getString(R.string.ads_show_all_description)
            visibility = View.VISIBLE
        } else {
            text = ""
            visibility = View.GONE
        }
    }
}

@BindingAdapter("isFavourite")
fun AppCompatImageView.setFavouriteIcon(isFavourite: Boolean?) {
    isFavourite?.let {
        if (it) {
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_full_favorite))
        } else {
            setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_empty_favorite))
        }
    }
}