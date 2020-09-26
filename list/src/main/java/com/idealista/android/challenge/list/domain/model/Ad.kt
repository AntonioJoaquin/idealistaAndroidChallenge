package com.idealista.android.challenge.list.domain.model

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.AdEntity

private interface Ad {
    val id: String
    val price: Double
    val typology: Typology
    val operation: Operation
}


// region AdItemList

data class AdItemList(
    override val id: String,
    override val price: Double,
    override val typology: Typology,
    override val operation: Operation,
    val thumbnail: String,
    val detailUrl: String
    ): Ad

fun AdEntity.toDomain() =
    AdItemList(
        propertyCode ?: "",
        price ?: 0.0,
        Typology.from(propertyType ?: ""),
        Operation.from(operation ?: ""),
        multimedia?.images?.get(0)?.url ?: "",
        detailUrl ?: ""
    )

// endregion AdItemList


// region AdDetail

data class AdDetail(
    override val id: String,
    override val price: Double,
    override val typology: Typology,
    override val operation: Operation,
    val propertyComment: String,
    val multimedias: Multimedias
): Ad

fun AdDetailEntity.toDomain() =
    AdDetail(
        adid ?: "",
        price ?: 0.0,
        Typology.from(extendedPropertyType ?: ""),
        Operation.from(operation ?: ""),
        propertyComment ?: "",
        multimedia?.toDomain() ?: Multimedias(
            emptyList()
        )
    )

// endregion AdDetail
