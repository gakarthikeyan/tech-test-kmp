package com.karthik.android.techtestkmp.di

import com.karthik.android.techtestkmp.data.network.APIService
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
    single { get<KtorClient>().createClient(getPlatformEngine()) }
    single { APIService(get()) }
}