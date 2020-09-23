package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.database.tables.AdTable
import com.idealista.android.challenge.list.ui.list.model.AdModel

class AdRepository(
    private val dataSource: AdDataSource
) {

    fun listFavouriteAds(): List<AdModel> =
        dataSource.listFavouriteAds()

    fun addFavouriteAd(adTable: AdTable) =
        dataSource.addFavouriteAd(adTable)

}