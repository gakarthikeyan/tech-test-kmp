package com.karthik.android.techtestkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform