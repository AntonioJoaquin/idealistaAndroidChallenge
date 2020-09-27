package com.idealista.android.challenge.list.ui.common.listAdapter

import com.idealista.android.challenge.list.ui.common.model.AdItemListModel

class AdItemListListener(
    private val clickListener: (ad: AdItemListModel) -> Unit
) {

    fun onClick(ad: AdItemListModel) =
        clickListener(ad)

}