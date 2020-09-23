package com.idealista.android.challenge.core.database.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AdTable(
    @PrimaryKey val propertyCode: String,
    val price: Double?
)