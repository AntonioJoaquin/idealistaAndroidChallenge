package com.idealista.android.challenge.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.AdDataSource
import com.idealista.android.challenge.list.data.AdRepository

object AdAssembler {

    private val adDataSource: AdDataSource by lazy { AdDataSource(CoreAssembler.favouriteAdApi) }

    val adRepository: AdRepository by lazy { AdRepository(adDataSource) }

}