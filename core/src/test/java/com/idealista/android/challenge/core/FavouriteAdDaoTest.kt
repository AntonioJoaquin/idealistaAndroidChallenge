package com.idealista.android.challenge.core

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.idealista.android.challenge.core.database.AdLocalEntity
import com.idealista.android.challenge.core.database.ApplicationDatabase
import com.idealista.android.challenge.core.database.FavouriteAdDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Config.OLDEST_SDK])
@RunWith(RobolectricTestRunner::class)
class FavouriteAdDaoTest {

    private lateinit var applicationDatabase: ApplicationDatabase
    private lateinit var favouriteAdDao: FavouriteAdDao

    private val favouriteAd = AdLocalEntity(
        "12345",
        "Ad test title",
        600.0,
        "https://testUrl.test",
        "testThumbnail"
    )


    @Before
    fun initDb() {
        applicationDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            ApplicationDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
        favouriteAdDao = applicationDatabase.favouriteAdDao()
    }


    @Test
    @Throws(Exception::class)
    fun listFavouriteAdsReturnsEmptyList() {
        val list = favouriteAdDao.listFavouriteAds()

        assertThat(list, equalTo(emptyList()))
    }

    @Test
    @Throws(Exception::class)
    fun addFavouriteAdsShouldInsertNewFavouriteAd() {
        val resultList = listOf(favouriteAd)

        favouriteAdDao.addFavouriteAd(favouriteAd)
        val list = favouriteAdDao.listFavouriteAds()

        assertThat(list, equalTo(resultList))
    }

    @ExperimentalCoroutinesApi
    @Test
    @Throws(Exception::class)
    fun isFavouriteAdsShouldReturnsIfAdIsIncluded() {
        favouriteAdDao.addFavouriteAd(favouriteAd)

        assertTrue(favouriteAdDao.isFavouriteAd(favouriteAd.id))
    }

    @ExperimentalCoroutinesApi
    @Test
    @Throws(Exception::class)
    fun removeFavouriteAdsShouldRemoveFavouriteAd() {
        favouriteAdDao.addFavouriteAd(favouriteAd)
        favouriteAdDao.removeFavouriteAd(favouriteAd)

        val list = favouriteAdDao.listFavouriteAds()

        assertThat(list, equalTo(emptyList()))
    }


    @After
    fun closeDb() {
        applicationDatabase.close()
    }

}