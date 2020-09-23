package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.database.FavouriteAdApi
import com.idealista.android.challenge.core.database.tables.AdTable
import com.idealista.android.challenge.list.ui.list.model.AdModel
import com.idealista.android.challenge.list.ui.list.model.toModel

class AdDataSource(
    private val favouriteAdApi: FavouriteAdApi
) {

    fun listFavouriteAds(): List<AdModel> =
        favouriteAdApi.listFavouriteAds().map { it.toModel() }

    fun addFavouriteAd(adTable: AdTable) =
        favouriteAdApi.addFavouriteAd(adTable)

}