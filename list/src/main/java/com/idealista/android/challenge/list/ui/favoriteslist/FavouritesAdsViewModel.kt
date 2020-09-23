package com.idealista.android.challenge.list.ui.favoriteslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idealista.android.challenge.list.AdAssembler
import com.idealista.android.challenge.list.domain.listFavouriteAds
import com.idealista.android.challenge.list.ui.list.model.AdModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavouritesAdsViewModel: ViewModel() {

    private val _ads = MutableLiveData<List<AdModel>>()
    val ads: LiveData<List<AdModel>>
        get() = _ads


    fun listFavouritesAds() {
        GlobalScope.launch {
            val favouritesAds = listFavouriteAds(AdAssembler.adRepository)
            _ads.postValue(favouritesAds)
        }
    }

}