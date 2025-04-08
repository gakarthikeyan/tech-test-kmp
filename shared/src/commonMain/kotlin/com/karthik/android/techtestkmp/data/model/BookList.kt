package com.karthik.android.techtestkmp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BookList(
    val books: List<Book>,
    val status: String,
    val total: Int
)
