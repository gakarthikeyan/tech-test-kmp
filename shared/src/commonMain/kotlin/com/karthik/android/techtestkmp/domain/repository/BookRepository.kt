package com.karthik.android.techtestkmp.domain.repository

import com.karthik.android.techtestkmp.data.model.BookList

interface BookRepository : BaseRepository {
    suspend fun getBooks(): BookList
}