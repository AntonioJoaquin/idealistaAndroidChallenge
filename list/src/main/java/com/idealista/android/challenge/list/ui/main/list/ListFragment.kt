package com.idealista.android.challenge.list.ui.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.intentTo
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.FragmentListBinding
import com.idealista.android.challenge.list.ui.ViewModelFactory
import com.idealista.android.challenge.list.ui.common.extensions.bindingInflate
import com.idealista.android.challenge.list.ui.common.listAdapter.AdItemListListener
import com.idealista.android.challenge.list.ui.common.listAdapter.AdListAdapter
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

class ListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this@ListFragment, ViewModelFactory()).get(ListViewModel::class.java)
    }
    private val adapter = AdListAdapter(
        AdItemListListener { goToAdDetail(it) }
    )

    private var binding: FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.bindingInflate(R.layout.fragment_list, container)
        binding?.let {
            it.lifecycleOwner = this@ListFragment
            it.viewModel = viewModel
            it.adapter = adapter
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }


    private fun init() {
        viewModel.onListNeeded()
    }

    private fun goToAdDetail(ad: AdItemListModel) {
        val intent = Addressable.Activity.Ads.intentTo()
        intent.putExtra("URL", ad.detailUrl)
        startActivity(intent)
    }

}