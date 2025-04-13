package com.karthik.android.techtestkmp.presentation.book

import com.karthik.android.techtestkmp.data.model.Book
import com.karthik.android.techtestkmp.domain.repository.BookRepository
import com.karthik.android.techtestkmp.utils.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 * [BookViewModel] class to initiate backend
 * operations along with coroutine.
 *
 * @param bookRepository: instance of [BookRepository]
 */
class BookViewModel(private val bookRepository : BookRepository) {

    private val _book = MutableStateFlow<UiState<List<Book>>>(UiState.Loading)
    val books : StateFlow<UiState<List<Book>>> = _book.asStateFlow()

    val viewModelScope = CoroutineScope(Dispatchers.Default)

    init {
        viewModelScope.launch {
            fetchBooks()
        }

    }

    /**
     * Method to fetch books from network
     * repository
     */
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