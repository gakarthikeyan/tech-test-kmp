package com.karthik.android.techtestkmp.android.util

/**
 * POC of Kotlin Multiplatform (Android Module)
 *
 * [Screen] utility sealed class
 * path setup for screen navigation
 *
 * @param route: a string value
 */
sealed class Screen(val route: String) {

    object Splash: Screen("splash")
    object BookList: Screen("book-list")
}