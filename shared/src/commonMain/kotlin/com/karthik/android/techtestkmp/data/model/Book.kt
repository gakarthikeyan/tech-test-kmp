package com.karthik.android.techtestkmp.data.model

import kotlinx.serialization.Serializable
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 *  data class for Book model
 *  @param authors: author name
 *  @param id: unique id
 *  @param image: image url
 *  @param subtitle: subtitle of the book
 *  @param title: title of the book
 *  @param url: description/online reading url
 */
@Serializable
data class Book(
    val authors: String,
    val id: String,
    val image: String,
    val subtitle: String,
    val title: String,
    val url: String
)