package com.idealista.android.challenge.list.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity

data class AdDetail(
    val id: String,
    val price: Double,
    val extendedPropertyType: Typology,
    val operation: Operation,
    val propertyComment: String
)

fun AdDetailEntity.toDomain() =
    AdDetail(
        adid ?: "",
        price ?: 0.0,
        Typology.from(extendedPropertyType ?: ""),
        Operation.from(operation ?: ""),
        propertyComment ?: ""
    )