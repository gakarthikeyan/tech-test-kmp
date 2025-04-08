package com.karthik.android.techtestkmp.android

import android.app.Application
import com.karthik.android.techtestkmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(sharedModule)
        }
    }
}