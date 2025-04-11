package com.karthik.android.techtestkmp.android.util

sealed class Screen(val route: String) {

    object Splash: Screen("splash")
    object BookList: Screen("book-list")
}