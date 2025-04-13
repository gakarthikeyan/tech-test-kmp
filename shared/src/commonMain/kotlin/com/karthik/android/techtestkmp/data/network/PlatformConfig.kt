package com.karthik.android.techtestkmp.data.network

/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 *  [PlatformConfig] object class which holds
 *  network host and base urls
 */
expect object PlatformConfig {
    val hostName : String
    val baseURL: String
}