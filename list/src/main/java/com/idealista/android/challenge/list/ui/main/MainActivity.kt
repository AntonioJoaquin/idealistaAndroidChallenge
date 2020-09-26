package com.idealista.android.challenge.list.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ActivityMainBinding
import com.idealista.android.challenge.list.ui.favoriteslist.FavouritesAdsFragment
import com.idealista.android.challenge.list.ui.main.list.ListFragment

class MainActivity : AppCompatActivity() {

    private val mainTabsAdapter by lazy {
        MainTabsAdapter(this)
    }

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.let {
            it.lifecycleOwner = this@MainActivity
        }

        init()
    }


    private fun init() {
        initViewPager()
        initTabLayout()
    }

    private fun initViewPager() {
        binding.viewPager2.adapter = mainTabsAdapter
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) {
            tab, position ->
            run {
                if (position == 0) {
                    tab.text = "Home"
                } else {
                    tab.text = "Favourites"
                }
            }
        }.attach()
    }

}