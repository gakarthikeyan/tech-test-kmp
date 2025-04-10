package com.karthik.android.techtestkmp.data.network

actual object PlatformConfig {
    actual val hostName: String get() = BuildConfig.HOST
    actual val baseURL: String get() = BuildConfig.BASE_URL

}