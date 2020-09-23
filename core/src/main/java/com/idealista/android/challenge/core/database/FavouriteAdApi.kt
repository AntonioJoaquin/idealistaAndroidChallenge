package com.idealista.android.challenge.core.database

import com.idealista.android.challenge.core.database.tables.AdTable

class FavouriteAdApi(
    private val applicationDatabase: ApplicationDatabase
) {

    fun listFavouriteAds(): List<AdTable> =
        applicationDatabase.favouriteAdDao().listFavouriteAds()

    fun addFavouriteAd(adTable: AdTable) =
        applicationDatabase.favouriteAdDao().addFavouriteAd(adTable)

}