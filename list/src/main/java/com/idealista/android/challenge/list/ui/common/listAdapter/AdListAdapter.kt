package com.idealista.android.challenge.list.ui.common.listAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ViewAdBinding
import com.idealista.android.challenge.list.ui.common.extensions.bindingInflate
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

class AdListAdapter(
    private val listener: AdItemListListener
): ListAdapter<AdItemListModel, AdListAdapter.ViewHolder>(Companion) {

    companion object: DiffUtil.ItemCallback<AdItemListModel>() {
        override fun areItemsTheSame(oldItem: AdItemListModel, newItem: AdItemListModel): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: AdItemListModel, newItem: AdItemListModel): Boolean =
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


        fun bind(ad: AdItemListModel) {
            binding.ad = ad
            binding.listener = listener
            binding.executePendingBindings()
        }

    }

}