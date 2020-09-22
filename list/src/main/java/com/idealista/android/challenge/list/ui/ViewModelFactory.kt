package com.idealista.android.challenge.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idealista.android.challenge.list.ui.ads.AdsViewModel

class ViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AdsViewModel() as T
    }

}