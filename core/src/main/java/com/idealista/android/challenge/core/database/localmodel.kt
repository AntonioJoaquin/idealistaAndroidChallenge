package com.idealista.android.challenge.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AdLocalEntity(
    @PrimaryKey val id: String,
    val title: String?,
    val price: Double?,
    val detailUrl: String?,
    val thumbnail: String?
)