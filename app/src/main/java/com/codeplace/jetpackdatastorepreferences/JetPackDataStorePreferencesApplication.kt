package com.codeplace.jetpackdatastorepreferences

import android.app.Application
import com.codeplace.jetpackdatastorepreferences.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JetPackDataStorePreferencesApplication:Application() {



    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JetPackDataStorePreferencesApplication)
            modules(appModule)
        }
    }


}