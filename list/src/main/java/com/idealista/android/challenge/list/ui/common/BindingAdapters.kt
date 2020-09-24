package com.idealista.android.challenge.list.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setPath")
fun AppCompatImageView.setPath(path: String?) {
    if (!path.isNullOrBlank()) {
        Picasso.with(context).load(path).into(this)
    }
}