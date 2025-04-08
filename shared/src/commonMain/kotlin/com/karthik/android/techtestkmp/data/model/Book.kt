package com.karthik.android.techtestkmp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val authors: String,
    val id: String,
    val image: String,
    val subtitle: String,
    val title: String,
    val url: String
)