package com.karthik.android.techtestkmp.android

import android.app.Application
import com.karthik.android.techtestkmp.android.di.networkModule
import com.karthik.android.techtestkmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        //for shared network module
        /*startKoin {
            androidContext(this@BaseApplication)
            modules(sharedModule)
        }*/

        //for android alone network module with chucker interceptor
        startKoin {
            androidContext(this@BaseApplication)
            modules(sharedModule, networkModule)
        }
    }
}