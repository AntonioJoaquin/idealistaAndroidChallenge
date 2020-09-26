package com.idealista.android.challenge.list.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.idealista.android.challenge.list.ui.favoriteslist.FavouritesAdsFragment
import com.idealista.android.challenge.list.ui.main.list.ListFragment

class MainTabsAdapter(
    private val fragmentActivity: FragmentActivity
): FragmentStateAdapter(
    fragmentActivity
) {

    private val FRAGMENTS_COUNT = 2


    override fun getItemCount(): Int =
        FRAGMENTS_COUNT

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            ListFragment()
        } else {
            FavouritesAdsFragment()
        }
    }

}