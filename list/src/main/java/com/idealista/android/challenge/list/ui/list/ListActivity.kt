package com.idealista.android.challenge.list.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.intentTo
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ActivityListBinding
import com.idealista.android.challenge.list.ui.ViewModelFactory
import com.idealista.android.challenge.list.ui.common.listAdapter.AdItemListListener
import com.idealista.android.challenge.list.ui.common.listAdapter.AdListAdapter
import com.idealista.android.challenge.list.ui.favoriteslist.FavouritesAdsActivity
import com.idealista.android.challenge.list.ui.list.model.AdModel

class ListActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this@ListActivity, ViewModelFactory()).get(ListViewModel::class.java)
    }
    private val adapter = AdListAdapter(
        AdItemListListener { goToAdDetail(it) }
    )

    private var binding: ActivityListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ListActivity, R.layout.activity_list)
        binding?.let {
            it.lifecycleOwner = this@ListActivity
            it.viewModel = viewModel
            it.adapter = adapter
        }

        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.list_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.item_favourites -> {
                startActivity(Intent(this, FavouritesAdsActivity::class.java))

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun init() {
        viewModel.onListNeeded()
    }

    private fun goToAdDetail(ad: AdModel) {
        val intent = Addressable.Activity.Ads.intentTo()
        intent.putExtra("URL", ad.detailUrl)
        startActivity(intent)
    }

}