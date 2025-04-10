package com.karthik.android.techtestkmp.data.network

import com.karthik.android.techtestkmp.BuildConfig

actual object PlatformConfig {
    actual val hostName: String get() = BuildConfig.HOST
    actual val baseURL: String get() = BuildConfig.BASE_URL

}