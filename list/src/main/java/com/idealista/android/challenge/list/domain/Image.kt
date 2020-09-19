package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.entity.ImageEntity

data class Image(
    val url: String
)

fun ImageEntity.toDomain() =
    Image(
        url
    )