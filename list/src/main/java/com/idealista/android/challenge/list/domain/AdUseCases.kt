package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.list.data.AdRepository
import com.idealista.android.challenge.list.ui.list.model.AdModel
import kotlin.collections.List

fun listFavouriteAds(adRepository: AdRepository): List<AdModel> =
    adRepository.listFavouriteAds()

fun checkIfIsFavouriteAd(adRepository: AdRepository, adId: String): Boolean =
    adRepository.isFavouriteAd(adId)

fun addFavouriteAd(adRepository: AdRepository, adLocalEntity: AdLocalEntity) =
    adRepository.addFavouriteAd(adLocalEntity)