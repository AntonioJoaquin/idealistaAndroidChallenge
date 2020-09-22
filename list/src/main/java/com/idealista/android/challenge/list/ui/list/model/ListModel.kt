package com.idealista.android.challenge.list.ui.list.model

data class ListModel(
    val ads: List<AdModel>)

fun com.idealista.android.challenge.list.domain.List.toModel() =
    ListModel(ads.map { it.toModel() })