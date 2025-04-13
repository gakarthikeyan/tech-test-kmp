package com.karthik.android.techtestkmp.domain.repository

import com.karthik.android.techtestkmp.data.model.BookList
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 * Book repository setup with
 * necessary methods which needs to be implemented
 */
interface BookRepository : BaseRepository {
    suspend fun getBooks(): BookList
}