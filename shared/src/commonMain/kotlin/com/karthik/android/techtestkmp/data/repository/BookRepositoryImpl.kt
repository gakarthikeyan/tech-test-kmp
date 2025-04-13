package com.karthik.android.techtestkmp.data.repository

import com.karthik.android.techtestkmp.data.model.BookList
import com.karthik.android.techtestkmp.data.network.APIService
import com.karthik.android.techtestkmp.domain.repository.BookRepository

/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 * [BookRepositoryImpl] book repository implementation class
 *
 * @param apiService: instance of [APIService]
 */
class BookRepositoryImpl(private val apiService: APIService): BookRepository {

    /**
     * Method to call books list api service
     *
     * @return books list
     */
    override suspend fun getBooks(): BookList {
        return apiService.fetchBooks()
    }

}