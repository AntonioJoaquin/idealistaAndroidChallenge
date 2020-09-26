package com.idealista.android.challenge.list.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ActivityMainBinding
import com.idealista.android.challenge.list.ui.favoriteslist.FavouritesAdsFragment
import com.idealista.android.challenge.list.ui.main.list.ListFragment

class MainActivity : AppCompatActivity() {

    private val mainTabsAdapter by lazy {
        MainTabsAdapter(this)
    }

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.let {
            it?.lifecycleOwner = this@MainActivity
        }

        initAdapter()
    }


    private fun initAdapter() {
        binding?.viewPager2?.adapter = mainTabsAdapter
    }

}