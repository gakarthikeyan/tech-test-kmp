package com.karthik.android.techtestkmp.android.di

import com.karthik.android.techtestkmp.android.data.network.HttpClientProvider
import com.karthik.android.techtestkmp.di.KtorClient
import org.koin.dsl.module

/**
 *  For android alone network call with
 *  chucker interceptor
 */

val networkModule = module {
    single { HttpClientProvider(get()) }
    single { KtorClient().createClient(get<HttpClientProvider>().getClient().engine) }
}