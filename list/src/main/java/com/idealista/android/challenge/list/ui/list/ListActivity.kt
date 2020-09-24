package com.idealista.android.challenge.list.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.intentTo
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.ui.favoriteslist.FavouritesAdsActivity
import com.idealista.android.challenge.list.ui.list.model.AdModel
import com.idealista.android.challenge.list.ui.list.model.ListModel

class ListActivity : AppCompatActivity(),
    ListView {

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        ListAssembler.presenter =
            ListPresenter(this)
        listAdapter = ListAdapter()
        findViewById<RecyclerView>(R.id.recycler).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = listAdapter
        }
        ListAssembler.presenter.onListNeeded()
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


    override fun render(list: ListModel) {
        listAdapter.set(list)
        listAdapter.listener(object :
            ListAdapter.AdListener {
            override fun onAdClicked(ad: AdModel) {
                ListAssembler.presenter.onAdClicked(ad)
            }
        })
    }

    override fun goToAdDetail(ad: AdModel) {
        val intent = Addressable.Activity.Ads.intentTo()
        intent.putExtra("URL", ad.detailUrl)
        startActivity(intent)
    }

}