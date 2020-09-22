package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.domain.List
import com.idealista.android.challenge.list.domain.list
import com.idealista.android.challenge.list.ui.list.model.AdModel
import com.idealista.android.challenge.list.ui.list.model.toModel

class ListPresenter(private val view: ListView) {

    fun onListNeeded() {
        UseCase<CommonError, List>()
            .bg(list(ListAssembler.listRepository))
            .map { it.toModel() }
            .ui {
                it.fold(
                    {

                    },
                    {
                        view.render(it)
                    }
                )
            }.run(CoreAssembler.executor)
    }

    fun onAdClicked(ad: AdModel) {
        view.goToAdDetail(ad)
    }

}