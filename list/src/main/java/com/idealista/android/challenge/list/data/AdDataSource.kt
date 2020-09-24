package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.core.database.FavouriteAdApi
import com.idealista.android.challenge.list.ui.list.model.AdModel
import com.idealista.android.challenge.list.ui.list.model.toModel

class AdDataSource(
    private val favouriteAdApi: FavouriteAdApi
) {

    fun listFavouriteAds(): List<AdModel> =
        favouriteAdApi.listFavouriteAds().map { it.toModel() }

    fun isFavouriteAd(adId: String): Boolean =
        favouriteAdApi.isFavouriteAd(adId)

    fun addFavouriteAd(adLocalEntity: AdLocalEntity) =
        favouriteAdApi.addFavouriteAd(adLocalEntity)

    fun removeFavouriteAd(adLocalEntity: AdLocalEntity) =
        favouriteAdApi.removeFavouriteAd(adLocalEntity)

}