package com.idealista.android.challenge.list.ui.common.listAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ViewAdBinding
import com.idealista.android.challenge.list.ui.ads.common.extensions.bindingInflate
import com.idealista.android.challenge.list.ui.list.model.AdModel

class AdListAdapter(
    private val listener: AdItemListListener
): ListAdapter<AdModel, AdListAdapter.ViewHolder>(Companion) {

    companion object: DiffUtil.ItemCallback<AdModel>() {
        override fun areItemsTheSame(oldItem: AdModel, newItem: AdModel): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: AdModel, newItem: AdModel): Boolean =
            oldItem.id == newItem.id

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent, listener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))


    class ViewHolder private constructor(
        private val binding: ViewAdBinding,
        private val listener: AdItemListListener
    ): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup, listener: AdItemListListener): ViewHolder {
                val binding = parent.bindingInflate<ViewAdBinding>(R.layout.view_ad)

                return ViewHolder(binding, listener)
            }
        }


        fun bind(ad: AdModel) {
            binding.ad = ad
            binding.listener = listener
            binding.executePendingBindings()
        }

    }

}