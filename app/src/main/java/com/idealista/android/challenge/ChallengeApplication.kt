package com.idealista.android.challenge

import android.app.Application
import com.idealista.android.challenge.core.Addressable
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.database.ApplicationDatabase

class ChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Addressable.PACKAGE_NAME = packageName
        CoreAssembler.stringsProvider = StringsProvider(baseContext)
        CoreAssembler.applicationDatabase = ApplicationDatabase.build(baseContext)
    }

}