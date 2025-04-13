package com.karthik.android.techtestkmp.utils
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 * [UiState] sealed class for network call
 * classification
 */
sealed class UiState <out T> {

    object Loading: UiState<Nothing>()
    data class Success<T>(val data:T): UiState<T>()
    data class Error(val message: String): UiState<Nothing>()

}