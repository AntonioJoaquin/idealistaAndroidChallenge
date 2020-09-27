package com.idealista.android.challenge.list.data.ad

import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

class AdRepository(
    private val dataSource: AdDataSource
) {

    fun listFavouriteAds(): List<AdItemListModel> =
        dataSource.listFavouriteAds()

    fun isFavouriteAd(adId: String) =
        dataSource.isFavouriteAd(adId)

    fun addFavouriteAd(adLocalEntity: AdLocalEntity) =
        dataSource.addFavouriteAd(adLocalEntity)

    fun removeFavouriteAd(adLocalEntity: AdLocalEntity) =
        dataSource.removeFavouriteAd(adLocalEntity)

}