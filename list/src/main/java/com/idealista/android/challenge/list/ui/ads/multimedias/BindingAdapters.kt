package com.idealista.android.challenge.list.ui.ads.multimedias

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager

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