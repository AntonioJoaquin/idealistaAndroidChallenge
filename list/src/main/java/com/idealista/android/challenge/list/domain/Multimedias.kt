package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.entity.MultimediasEntity
import kotlin.collections.List

data class Multimedias(
    val images: List<Image>
)

fun MultimediasEntity.toDomain() =
    Multimedias(
        images?.map { it.toDomain() } ?: emptyList()
    )