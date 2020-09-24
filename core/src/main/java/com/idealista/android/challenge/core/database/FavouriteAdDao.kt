package com.idealista.android.challenge.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavouriteAdDao {

    @Query("SELECT * FROM adlocalentity")
    fun listFavouriteAds(): List<AdLocalEntity>

    @Query("SELECT EXISTS( SELECT * FROM adlocalentity WHERE id = :adId)")
    fun isFavouriteAd(adId: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavouriteAd(favoriteAd: AdLocalEntity)

}