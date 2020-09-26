package com.idealista.android.challenge.list.ui.common.model

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.R
import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.string
import com.idealista.android.challenge.list.domain.model.AdDetail
import com.idealista.android.challenge.list.domain.model.AdItemList
import java.util.*

private interface AdModel {
    val id: String
    val title: String
    val price: String
}


// region AdItemListModel

data class AdItemListModel(
    override val id: String,
    override val title: String,
    override val price: String,
    val detailUrl: String,
    val thumbnail: String
): AdModel

fun AdItemList.toModel() =
    AdItemListModel(
        id,
        formatTitle(typology, operation),
        formatPrice(price),
        detailUrl,
        thumbnail
    )

fun AdLocalEntity.toModel() =
    AdItemListModel(
        id,
        title ?: "",
        formatPrice(price ?: 0.0),
        detailUrl ?: "",
        thumbnail ?: ""
    )

// endregion AdItemList


// region AdDetailModel

data class AdDetailModel(
    override val id: String,
    override val title: String,
    override val price: String,
    val propertyComment: String,
    val multimedias: List<String>
): AdModel {

    fun toDatabaseEntity(adUrl: String) =
        AdLocalEntity(
            id,
            title,
            price.split(" ")[0].toDouble(),
            adUrl,
            multimedias[0]
        )

}

fun AdDetail.toDomain() =
    AdDetailModel(
        id,
        formatTitle(typology, operation),
        formatPrice(price),
        propertyComment,
        multimedias.images.map { it.url }
    )

// endregion AdDetailModel


private fun formatTitle(typology: Typology, operation: Operation) =
    CoreAssembler.stringsProvider.string(
        R.string.typology_at_operation,
        typology.string(),
        operation.string().toLowerCase(Locale.ROOT))

private fun formatPrice(price: Double) = "$price €"