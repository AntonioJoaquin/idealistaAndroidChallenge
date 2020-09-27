package com.idealista.android.challenge.list.ui.common.listAdapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.list.ui.common.LoadingState
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

// region RecyclerView

@BindingAdapter("bindAdapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("setItems")
fun RecyclerView.setItems(items: List<AdItemListModel>?) {
    (adapter as? AdListAdapter)?.submitList(items ?: emptyList())
}

// endregion RecyclerView


@BindingAdapter(value = ["visibilityState", "showWhenLoading"])
fun View.visibilityByState(loadingState: LoadingState?, showWhenLoading: Boolean) {
    visibility = when(loadingState) {
        LoadingState.LOADING -> if (showWhenLoading) View.VISIBLE else View.GONE
        else -> if (showWhenLoading) View.GONE else View.VISIBLE
    }
}