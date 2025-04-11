package com.karthik.android.techtestkmp.presentation.book

import com.karthik.android.techtestkmp.data.model.Book
import com.karthik.android.techtestkmp.data.repository.BookRepositoryImpl
import com.karthik.android.techtestkmp.domain.repository.BookRepository
import com.karthik.android.techtestkmp.utils.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookViewModel(private val bookRepository : BookRepository) {

    private val _book = MutableStateFlow<UiState<List<Book>>>(UiState.Loading)
    val books : StateFlow<UiState<List<Book>>> = _book.asStateFlow()

    val viewModelScope = CoroutineScope(Dispatchers.Default)

    init {
        viewModelScope.launch {
            fetchBooks()
        }

    }

    suspend fun fetchBooks(){
        try {
            delay(2000)
            val result = bookRepository.getBooks().books
            _book.value = UiState.Success(result)
        } catch (e: Exception){
            e.printStackTrace()
            _book.value = UiState.Error("Empty Response")
        }
    }

}