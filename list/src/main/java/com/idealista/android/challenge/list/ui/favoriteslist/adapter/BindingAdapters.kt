package com.idealista.android.challenge.list.ui.favoriteslist.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.list.ui.list.model.AdModel

// region RecyclerView

@BindingAdapter("bindAdapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("setItems")
fun RecyclerView.setItems(items: List<AdModel>?) {
    (adapter as? FavouritesAdsAdapter)?.submitList(items ?: emptyList())
}

// endregion RecyclerView