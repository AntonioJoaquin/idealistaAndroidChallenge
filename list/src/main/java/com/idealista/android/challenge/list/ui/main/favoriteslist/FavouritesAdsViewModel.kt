package com.idealista.android.challenge.list.ui.main.favoriteslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idealista.android.challenge.list.AdAssembler
import com.idealista.android.challenge.list.domain.usecase.listFavouriteAds
import com.idealista.android.challenge.list.ui.common.LoadingState
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavouritesAdsViewModel: ViewModel() {

    private val _ads = MutableLiveData<List<AdItemListModel>>()
    val ads: LiveData<List<AdItemListModel>>
        get() = _ads

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState


    fun listFavouritesAds() {
        _loadingState.postValue(LoadingState.LOADING)

        GlobalScope.launch {
            val favouritesAds =
                listFavouriteAds(
                    AdAssembler.adRepository
                )

            _ads.postValue(favouritesAds)
            _loadingState.postValue(LoadingState.LOADED)
        }
    }

}