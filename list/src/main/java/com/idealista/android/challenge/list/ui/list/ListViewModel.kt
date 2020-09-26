package com.idealista.android.challenge.list.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.domain.model.List
import com.idealista.android.challenge.list.domain.usecase.list
import com.idealista.android.challenge.list.ui.list.model.ListModel
import com.idealista.android.challenge.list.ui.list.model.toModel

class ListViewModel: ViewModel() {

    private val _listModel = MutableLiveData<ListModel>()
    val listModel: LiveData<ListModel>
        get() = _listModel


    fun onListNeeded() {
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

                    },
                    {
                        _listModel.postValue(it)
                    }
                )
            }.run(CoreAssembler.executor)
    }

}