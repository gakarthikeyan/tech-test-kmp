package com.karthik.android.techtestkmp.data.repository

import com.karthik.android.techtestkmp.data.model.Book
import com.karthik.android.techtestkmp.data.model.BookList
import com.karthik.android.techtestkmp.data.network.APIService
import com.karthik.android.techtestkmp.domain.repository.BookRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class BookRepositoryImpl(private val apiService: APIService): BookRepository {

    override suspend fun getBooks(): BookList {
        return apiService.fetchBooks()
    }


}