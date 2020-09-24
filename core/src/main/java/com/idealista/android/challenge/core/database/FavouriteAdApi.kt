package com.idealista.android.challenge.core.database


class FavouriteAdApi(
    private val applicationDatabase: ApplicationDatabase
) {

    fun listFavouriteAds(): List<AdLocalEntity> =
        applicationDatabase.favouriteAdDao().listFavouriteAds()

    fun isFavouriteAd(adId: String): Boolean =
        applicationDatabase.favouriteAdDao().isFavouriteAd(adId)

    fun addFavouriteAd(adLocalEntity: AdLocalEntity) =
        applicationDatabase.favouriteAdDao().addFavouriteAd(adLocalEntity)

    fun removeFavouriteAd(adLocalEntity: AdLocalEntity) =
        applicationDatabase.favouriteAdDao().removeFavouriteAd(adLocalEntity)

}