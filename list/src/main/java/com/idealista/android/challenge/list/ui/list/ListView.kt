package com.idealista.android.challenge.list.ui.list

import com.idealista.android.challenge.list.ui.list.model.AdModel
import com.idealista.android.challenge.list.ui.list.model.ListModel

interface ListView {
    fun render(list: ListModel)

    fun goToAdDetail(ad: AdModel)
}