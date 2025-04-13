package com.karthik.android.techtestkmp.data.network

import com.karthik.android.techtestkmp.BuildConfig
/**
 * POC of Kotlin Multiplatform
 *
 *  [PlatformConfig] object actual class
 *  assign actual values of network config
 */
actual object PlatformConfig {
    actual val hostName: String get() = BuildConfig.HOST
    actual val baseURL: String get() = BuildConfig.BASE_URL

}