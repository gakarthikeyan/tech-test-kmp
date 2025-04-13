package com.karthik.android.techtestkmp.data.model

import kotlinx.serialization.Serializable
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 *  data class for BookList model
 *  @param books: list of books
 *  @param status: book status
 *  @param total: books count in a single request
 */
@Serializable
data class BookList(
    val books: List<Book>,
    val status: String,
    val total: Int
)
