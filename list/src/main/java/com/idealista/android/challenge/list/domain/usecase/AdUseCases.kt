package com.idealista.android.challenge.list.domain.usecase

import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.list.data.ad.AdRepository
import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

fun listFavouriteAds(adRepository: AdRepository): List<AdItemListModel> =
    adRepository.listFavouriteAds()

fun checkIfIsFavouriteAd(adRepository: AdRepository, adId: String): Boolean =
    adRepository.isFavouriteAd(adId)

fun addFavouriteAd(adRepository: AdRepository, adLocalEntity: AdLocalEntity) =
    adRepository.addFavouriteAd(adLocalEntity)

fun removeFavouriteAd(adRepository: AdRepository, adLocalEntity: AdLocalEntity) =
    adRepository.removeFavouriteAd(adLocalEntity)