package com.idealista.android.challenge.list.data.ad

import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.core.database.FavouriteAdApi
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel
import com.idealista.android.challenge.list.ui.common.model.toModel

class AdDataSource(
    private val favouriteAdApi: FavouriteAdApi
) {

    fun listFavouriteAds(): List<AdItemListModel> =
        favouriteAdApi.listFavouriteAds().map { it.toModel() }

    fun isFavouriteAd(adId: String): Boolean =
        favouriteAdApi.isFavouriteAd(adId)

    fun addFavouriteAd(adLocalEntity: AdLocalEntity) =
        favouriteAdApi.addFavouriteAd(adLocalEntity)

    fun removeFavouriteAd(adLocalEntity: AdLocalEntity) =
        favouriteAdApi.removeFavouriteAd(adLocalEntity)

}