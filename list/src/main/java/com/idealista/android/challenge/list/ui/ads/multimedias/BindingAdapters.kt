package com.idealista.android.challenge.list.ui.ads.multimedias

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso

@BindingAdapter("bindAdapter")
fun ViewPager.bindAdapter(adapter: ImageSliderAdapter?) {
    adapter?.let {
        this.adapter = it
    }
}

@BindingAdapter("setItems")
fun ViewPager.setItems(items: List<String>?) {
    (adapter as? ImageSliderAdapter)?.let {
        it.items = items ?: emptyList()
    }
}

@BindingAdapter("setPath")
fun AppCompatImageView.setPath(path: String?) {
    if (!path.isNullOrBlank()) {
        Picasso.with(context).load(path).into(this)
    }
}