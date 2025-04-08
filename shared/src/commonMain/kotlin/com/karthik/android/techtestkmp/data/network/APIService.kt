package com.karthik.android.techtestkmp.data.network

import com.karthik.android.techtestkmp.data.model.BookList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class APIService (private val client: HttpClient){

    suspend fun fetchBooks(): BookList {
        return client.get("/api/recent").body()
    }

}