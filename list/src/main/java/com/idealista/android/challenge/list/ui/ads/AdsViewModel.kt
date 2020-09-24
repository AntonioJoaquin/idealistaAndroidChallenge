package com.idealista.android.challenge.list.ui.ads

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.AdAssembler
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.domain.AdDetail
import com.idealista.android.challenge.list.domain.adDetail
import com.idealista.android.challenge.list.domain.addFavouriteAd
import com.idealista.android.challenge.list.domain.checkIfIsFavouriteAd
import com.idealista.android.challenge.list.ui.ads.model.AdDetailModel
import com.idealista.android.challenge.list.ui.ads.model.toDomain
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AdsViewModel: ViewModel() {

    private val _ad: MutableLiveData<AdDetailModel> = MutableLiveData()
    val ad: LiveData<AdDetailModel>
        get() = _ad

    private val _isFavouriteAd: MutableLiveData<Boolean> = MutableLiveData()
    val isFavouriteAd: LiveData<Boolean>
        get() = _isFavouriteAd

    private lateinit var adUrl: String


    fun init(adUrl: String) {
        this.adUrl = adUrl

        val urlPath = adUrl.substring(adUrl.lastIndexOf('/') + 1)
        getAdDetails(urlPath)
    }


    private fun getAdDetails(urlPath: String) {
        UseCase<CommonError, AdDetail>()
            .bg(adDetail(ListAssembler.listRepository, urlPath))
            .map { it.toDomain() }
            .ui {
                it.fold(
                    {
                        Log.e("ERROR", it.toString())
                    },
                    {
                        setIsFavouriteAd(it.id)
                        _ad.postValue(it)
                    }
                )
            }.run(CoreAssembler.executor)
    }

    fun addToFavourites() {
        GlobalScope.launch {
            addFavouriteAd(
                AdAssembler.adRepository,
                (ad.value as AdDetailModel).toDatabaseEntity(adUrl)
            )

            _isFavouriteAd.postValue(true)
        }
    }


    private fun setIsFavouriteAd(adId: String) {
        GlobalScope.launch {
            val isFavourite = checkIfIsFavouriteAd(AdAssembler.adRepository, adId)
            _isFavouriteAd.postValue(isFavourite)
        }
    }

}