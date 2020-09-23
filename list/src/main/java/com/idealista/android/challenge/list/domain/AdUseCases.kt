package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.database.tables.AdTable
import com.idealista.android.challenge.list.data.AdRepository
import com.idealista.android.challenge.list.ui.list.model.AdModel
import kotlin.collections.List

fun listFavouriteAds(adRepository: AdRepository): List<AdModel> =
    adRepository.listFavouriteAds()

fun addFavouriteAd(adRepository: AdRepository, adTable: AdTable) =
    adRepository.addFavouriteAd(adTable)