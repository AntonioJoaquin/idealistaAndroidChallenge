package com.idealista.android.challenge.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AdLocalEntity::class], version = 1)
abstract class ApplicationDatabase: RoomDatabase() {

    companion object {

        fun build(context: Context) =
            Room.databaseBuilder(
                context,
                ApplicationDatabase::class.java,
                "application-database"
            ).build()

    }


    abstract fun favouriteAdDao(): FavouriteAdDao

}