package com.idealista.android.challenge.list.ui.main.list.model

import com.idealista.android.challenge.list.ui.common.model.AdItemListModel
import com.idealista.android.challenge.list.ui.common.model.toModel

data class ListModel(
    val ads: List<AdItemListModel>)

fun com.idealista.android.challenge.list.domain.model.List.toModel() =
    ListModel(ads.map { it.toModel() })