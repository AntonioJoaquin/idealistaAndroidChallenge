package com.idealista.android.challenge.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.list.ListDataSource
import com.idealista.android.challenge.list.data.list.ListRepository

object ListAssembler {

    private val listDataSource: ListDataSource by lazy {
        ListDataSource(
            CoreAssembler.listApi
        )
    }

    val listRepository: ListRepository by lazy {
        ListRepository(
            listDataSource
        )
    }

}