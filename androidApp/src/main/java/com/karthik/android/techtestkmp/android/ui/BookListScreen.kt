package com.karthik.android.techtestkmp.android.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.karthik.android.techtestkmp.data.model.Book
import com.karthik.android.techtestkmp.presentation.book.BookViewModel
import com.karthik.android.techtestkmp.utils.UiState
import org.koin.compose.koinInject

/**
 * POC of Kotlin Multiplatform (Android Module)
 *
 * [BookListScreen] composable function
 * collect books data from network and populate
 * books list
 */
@Composable
fun BookListScreen(){

    val context = LocalContext.current
    val viewModel  = koinInject<BookViewModel>()
    val uiState = viewModel.books.collectAsState()

    when(val state = uiState.value){
        is UiState.Loading ->{
            Box(modifier = Modifier.height(50.dp).width(50.dp), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }

        }
        is UiState.Success<List<Book>> -> {
            val allBooks = state.data
            LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                items(allBooks) { book ->
                    BookItem(book)
                }

            }
        }
        is UiState.Error -> {
            val msg = state.message
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }


}
/**
 *[BookItem] composable function
 * custom UI for book view
 *
 * @param book: instance of [Book]
 * @param context: current context
 */
@Composable
fun BookItem(book: Book, context: Context = LocalContext.current){
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(5.dp)
            .clickable {
                Toast.makeText(context, book.title, Toast.LENGTH_SHORT).show()
            }
    ){

        Image(
            painter = rememberAsyncImagePainter(book.image),
            contentDescription = book.authors,
            modifier = Modifier.fillMaxWidth().height(250.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Text(
                text = book.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = book.authors,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Magenta
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}