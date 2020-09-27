package com.idealista.android.challenge.list.domain.usecase

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.data.list.ListRepository
import com.idealista.android.challenge.list.domain.model.AdDetail
import com.idealista.android.challenge.list.domain.model.List

fun list(repository: ListRepository): () -> Either<CommonError, List> = {
    repository.list()
}

fun adDetail(repository: ListRepository, adPath: String): () -> Either<CommonError, AdDetail> = {
    repository.adDetail(adPath)
}