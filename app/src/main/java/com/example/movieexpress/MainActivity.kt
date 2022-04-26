package com.example.movieexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.movieexpress.screen.BottomBar
import com.example.movieexpress.screen.Navigation
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel
import com.example.movieexpress.ui.theme.MovieeXpressTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieeXpressTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        content = {
            Navigation(navController = navController)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieeXpressTheme {
        Content()
    }
}