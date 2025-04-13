package com.karthik.android.techtestkmp.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.karthik.android.techtestkmp.android.R
import com.karthik.android.techtestkmp.android.util.Screen
import kotlinx.coroutines.delay

/**
 * POC of Kotlin Multiplatform (Android Module)
 *
 * [SplashScreen] Composable function
 * setup splash screen and main screen navigation
 *
 * @param naveController: instance of [NavHostController]
 */
@Composable
fun SplashScreen(naveController: NavHostController){

    LaunchedEffect(Unit) {
        delay(3000L)
        naveController.navigate(Screen.BookList.route){
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(color = Color(0xFF121212)),
        contentAlignment = Alignment.Center){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(id = R.drawable.open_book),
                contentDescription = "App Logo",
                modifier = Modifier.size(150.dp))
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(color = Color.White)
        }
    }
}