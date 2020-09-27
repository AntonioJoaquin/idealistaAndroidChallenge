package com.idealista.android.challenge.list.ui.main.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.domain.model.List
import com.idealista.android.challenge.list.domain.usecase.list
import com.idealista.android.challenge.list.ui.common.LoadingState
import com.idealista.android.challenge.list.ui.main.list.model.ListModel
import com.idealista.android.challenge.list.ui.main.list.model.toModel

class ListViewModel: ViewModel() {

    private val _listModel = MutableLiveData<ListModel>()
    val listModel: LiveData<ListModel>
        get() = _listModel

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState


    fun onListNeeded() {
        _loadingState.postValue(LoadingState.LOADING)

        UseCase<CommonError, List>()
            .bg(
                list(
                    ListAssembler.listRepository
                )
            )
            .map { it.toModel() }
            .ui {
                it.fold(
                    {
                        _loadingState.postValue(LoadingState.error(it.toString()))
                        Log.e("ERROR_LIST", it.toString())
                    },
                    {
                        _listModel.postValue(it)
                        _loadingState.postValue(LoadingState.LOADED)
                    }
                )
            }.run(CoreAssembler.executor)
    }

}