package com.example.movieexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.movieexpress.screen.BottomBar
import com.example.movieexpress.screen.Navigation
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel
import com.example.movieexpress.ui.theme.MovieeXpressTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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
    val viewModel: HomeViewModel = hiltViewModel()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        content = { it ->
            Box(Modifier.padding(it)) {
                viewModel.state.isError.let { error ->
                    if (error.isNotEmpty()) {
                        rememberCoroutineScope().launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = error,
                                actionLabel = "OK"
                            )
                            when (result) {
                                SnackbarResult.Dismissed -> {}
                                SnackbarResult.ActionPerformed -> {}
                            }
                        }
                    }
                }
                Navigation(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        },
        scaffoldState = scaffoldState
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieeXpressTheme {
        Content()
    }
}