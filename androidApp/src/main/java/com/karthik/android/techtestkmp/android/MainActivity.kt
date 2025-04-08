package com.karthik.android.techtestkmp.android

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.karthik.android.techtestkmp.data.model.Book
import com.karthik.android.techtestkmp.presentation.book.BookViewModel
import org.koin.compose.koinInject
import org.koin.java.KoinJavaComponent.inject


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    GreetingView(Greeting().greet())
                    BookListScreen()
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

/*@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}*/

@Composable
fun BookListScreen(){

    val viewModel  = koinInject<BookViewModel>()
    val books = viewModel.books.collectAsState()

    if(books.value.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(books.value) { book ->
                BookItem(book)
            }

        }
    } else {
        Toast.makeText(LocalContext.current, "Empty Response", Toast.LENGTH_SHORT).show()
    }



}

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