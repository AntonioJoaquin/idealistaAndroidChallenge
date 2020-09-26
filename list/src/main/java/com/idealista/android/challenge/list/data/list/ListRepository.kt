package com.idealista.android.challenge.list.data.list

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.domain.model.AdDetail
import com.idealista.android.challenge.list.domain.model.List
import com.idealista.android.challenge.list.domain.model.toDomain

class ListRepository(private val dataSource: ListDataSource) {

    fun list(): Either<CommonError, List> = dataSource.list().map { it.toDomain() }

    fun adDetail(adPath: String): Either<CommonError, AdDetail> = dataSource.adDetail(adPath).map { it.toDomain() }

}