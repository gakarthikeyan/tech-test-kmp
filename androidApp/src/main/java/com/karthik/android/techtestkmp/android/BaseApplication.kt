package com.karthik.android.techtestkmp.android

import android.app.Application
import com.karthik.android.techtestkmp.android.di.networkModule
import com.karthik.android.techtestkmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * POC of Kotlin Multiplatform (Android Module)
 *
 * [BaseApplication] application class
 * init base setup for core module and dependant
 * libs initialization.
 */
class BaseApplication : Application(){

    /**
     * Lifecycle method onCreate
     *
     * init Koin dependency injection along with
     * shared network module form shared module and
     * android alone network module with chucker library
     * interceptor
     */
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