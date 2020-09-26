package com.idealista.android.challenge.list.ui.common.extensions

import android.widget.TextView
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.ui.main.ads.common.DEFAULT_LINES_SPANNABLE_TEXT

fun TextView.clickForSpannableText(spannableText: TextView) {
    setOnClickListener {
        if (DEFAULT_LINES_SPANNABLE_TEXT == spannableText.maxLines) {
            spannableText.maxLines = Int.MAX_VALUE
            text = context.resources.getString(R.string.ads_hide_all_description)
        } else {
            spannableText.maxLines =
                DEFAULT_LINES_SPANNABLE_TEXT
            text = context.resources.getString(R.string.ads_show_all_description)
        }
    }
}