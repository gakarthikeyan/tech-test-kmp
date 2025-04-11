package com.karthik.android.techtestkmp.android

import com.karthik.android.techtestkmp.android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.karthik.android.techtestkmp.android.ui.BookListScreen
import com.karthik.android.techtestkmp.android.ui.SplashScreen
import com.karthik.android.techtestkmp.android.util.Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavHost(navHostController = navController)
                }
            }
        }
    }
}

@Composable
fun AppNavHost(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = Screen.BookList.route){
        composable(Screen.Splash.route) { SplashScreen(navHostController) } // Not in use (alternate implemented in styles)
        composable(Screen.BookList.route) { BookListScreen() }
    }
}