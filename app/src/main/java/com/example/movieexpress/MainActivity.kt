package com.example.movieexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movieexpress.screen.BottomBar
import com.example.movieexpress.screen.BottomMenuItem
import com.example.movieexpress.screen.Navigation
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel
import com.example.movieexpress.ui.theme.MovieeXpressTheme
import dagger.hilt.android.AndroidEntryPoint
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
    val routes = listOf(
        BottomMenuItem.Home.route,
        BottomMenuItem.Search.route,
        BottomMenuItem.Settings.route,
        BottomMenuItem.Series.route,
        BottomMenuItem.Movies.route
    )
    val showTopAndBottomBar =
        navController.currentBackStackEntryAsState().value?.destination?.route in routes
    Scaffold(
        topBar = {
            Row {
                if (!showTopAndBottomBar) {
                    IconButton(
                        onClick = { navController.navigateUp() },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = 10.dp, top = 12.dp)
                )
            }
        },
        bottomBar = {
            if (showTopAndBottomBar) {
                BottomBar(navController)
            }
        },
        content = {
            Box(Modifier.padding(it)) {
                viewModel.state.isError.let { error ->
                    if (error.isNotEmpty()) {
                        rememberCoroutineScope().launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = error,
                                actionLabel = "OK"
                            )
                            when (result) {
                                SnackbarResult.Dismissed -> {
                                    viewModel.clearErrorMessage()
                                }
                                SnackbarResult.ActionPerformed -> {
                                    viewModel.clearErrorMessage()
                                }
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