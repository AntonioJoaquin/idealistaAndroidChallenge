package com.idealista.android.challenge.list.ui.favoriteslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.intentTo
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ActivityFavouritesAdsBinding
import com.idealista.android.challenge.list.ui.ViewModelFactory
import com.idealista.android.challenge.list.ui.common.listAdapter.AdItemListListener
import com.idealista.android.challenge.list.ui.common.listAdapter.AdListAdapter
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

class FavouritesAdsActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this@FavouritesAdsActivity, ViewModelFactory()).get(FavouritesAdsViewModel::class.java)
    }
    private val adapter = AdListAdapter(
        AdItemListListener { goToAdDetail(it) }
    )

    private var binding: ActivityFavouritesAdsBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_favourites_ads)
        binding.let {
            it?.lifecycleOwner = this@FavouritesAdsActivity
            it?.viewModel = viewModel
            it?.adapter = adapter
        }

        init()
    }


    private fun init() {
        viewModel.listFavouritesAds()
    }

    private fun goToAdDetail(ad: AdItemListModel) {
        val intent = Addressable.Activity.Ads.intentTo()
        intent.putExtra("URL", ad.detailUrl)
        startActivity(intent)
    }

}