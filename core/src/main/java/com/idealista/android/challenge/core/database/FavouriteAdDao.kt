package com.idealista.android.challenge.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.idealista.android.challenge.core.database.tables.AdTable

@Dao
interface FavouriteAdDao {

    @Query("SELECT * FROM adtable")
    fun listFavouriteAds(): List<AdTable>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavouriteAd(favoriteAd: AdTable)

}