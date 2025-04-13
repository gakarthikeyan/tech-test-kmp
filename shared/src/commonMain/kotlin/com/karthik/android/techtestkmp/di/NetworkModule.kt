package com.karthik.android.techtestkmp.di

import com.karthik.android.techtestkmp.data.network.APIService
import org.koin.dsl.module
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 * Koin DI module to inject
 * Ktor client and api service
 */
val networkModule = module {
    single { KtorClient() }
    single { get<KtorClient>().createClient(getPlatformEngine()) }
    single { APIService(get()) }
}