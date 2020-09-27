package com.idealista.android.challenge.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.ad.AdDataSource
import com.idealista.android.challenge.list.data.ad.AdRepository

object AdAssembler {

    private val adDataSource: AdDataSource by lazy {
        AdDataSource(
            CoreAssembler.favouriteAdApi
        )
    }

    val adRepository: AdRepository by lazy {
        AdRepository(
            adDataSource
        )
    }

}