package com.idealista.android.challenge.list.ui.common.listAdapter

import com.idealista.android.challenge.list.ui.list.model.AdModel

class AdItemListListener(
    private val clickListener: (ad: AdModel) -> Unit
) {

    fun onClick(ad: AdModel) =
        clickListener(ad)

}