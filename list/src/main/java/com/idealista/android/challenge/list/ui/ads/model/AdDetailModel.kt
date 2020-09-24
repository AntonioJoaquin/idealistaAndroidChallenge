package com.idealista.android.challenge.list.ui.ads.model

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.database.tables.AdTable
import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.string
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.domain.AdDetail
import java.util.*

data class AdDetailModel(
    val id: String,
    val title: String,
    val price: String,
    val propertyComment: String,
    val multimedias: List<String>
) {

    fun toDatabaseEntity(adUrl: String) =
        AdTable(
            id,
            multimedias[0],
            title,
            price.split(" ")[0].toDouble(),
            adUrl
        )

}

fun AdDetail.toDomain() =
    AdDetailModel(
        id,
        formatTitle(
            extendedPropertyType,
            operation
        ),
        formatPrice(price),
        propertyComment,
        multimedias.images.map { it.url }
    )


private fun formatTitle(typology: Typology, operation: Operation) =
    CoreAssembler.stringsProvider.string(
        R.string.typology_at_operation,
        typology.string(),
        operation.string().toLowerCase(Locale.ROOT)
    )

private fun formatPrice(price: Double) = "$price €"