package com.idealista.android.challenge.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.list.data.ListDataSource
import com.idealista.android.challenge.list.data.ListRepository

object ListAssembler {

    private val listDataSource: ListDataSource by lazy { ListDataSource(CoreAssembler.listApi) }

    val listRepository: ListRepository by lazy { ListRepository(listDataSource) }

}