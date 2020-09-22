package com.idealista.android.challenge.core.api

import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.ListEntity
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    
    @GET("/v3/364d4f62-c183-4f12-ba16-49bfc5c820ab")
    fun list(): Call<ListEntity>

    @GET("/v3/{adDetailPath}")
    fun adDetail(@Path("adDetailPath") adPath: String): Call<AdDetailEntity>

}