package com.karthik.android.techtestkmp.presentation.book

import com.karthik.android.techtestkmp.data.model.Book
import com.karthik.android.techtestkmp.data.repository.BookRepositoryImpl
import com.karthik.android.techtestkmp.domain.repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val bookRepository : BookRepository) {

    private val _book = MutableStateFlow<List<Book>>(emptyList())
    val books : StateFlow<List<Book>> = _book.asStateFlow()

    val viewModelScope = CoroutineScope(Dispatchers.Default)

    init {
        viewModelScope.launch {
            fetchBooks()
        }

    }

    suspend fun fetchBooks(){
        try {
            _book.value = bookRepository.getBooks().books
        } catch (e: Exception){
            e.printStackTrace()
            _book.value = emptyList<Book>()
        }
    }

}