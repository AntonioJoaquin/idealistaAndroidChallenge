package com.idealista.android.challenge.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException

class ViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            return modelClass.newInstance()
        } catch (ex: InstantiationError) {
            throw RuntimeException("Cannot create a instance of $modelClass", ex)
        } catch (ex: IllegalAccessException) {
            throw RuntimeException("Cannot create a instance of $modelClass", ex)
        }
    }

}