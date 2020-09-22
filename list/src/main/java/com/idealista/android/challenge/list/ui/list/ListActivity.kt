package com.idealista.android.challenge.list.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.intentTo
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.R
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
        intent.putExtra("URL", ad.detailUrl.substring(ad.detailUrl.lastIndexOf('/')+1))
        startActivity(intent)
    }

}