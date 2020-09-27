package com.idealista.android.challenge.list.domain.model

import com.idealista.android.challenge.core.model.entity.ListEntity
import kotlin.collections.List

data class List(
    val ads: List<AdItemList>)

fun ListEntity.toDomain() =
    List(elementList.map { it.toDomain() })