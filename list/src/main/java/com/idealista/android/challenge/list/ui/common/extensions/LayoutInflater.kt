package com.idealista.android.challenge.list.ui.common.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> LayoutInflater.bindingInflate(
    @LayoutRes layoutRes: Int,
    container: ViewGroup?,
    attachToRoot: Boolean = false
): T = DataBindingUtil.inflate(this, layoutRes, container, attachToRoot)