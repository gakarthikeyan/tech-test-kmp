package com.karthik.android.techtestkmp.data.network

import com.karthik.android.techtestkmp.data.model.BookList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 *  API service class which calls the
 *  respective urls/endpoint to fetch network data
 *
 *  @param client: instance of [HttpClient]
 */
class APIService (private val client: HttpClient){

    /**
     * Method to fetch books list from network
     *
     *  @return books list
     */
    suspend fun fetchBooks(): BookList {
        return client.get("/api/recent").body()
    }

}