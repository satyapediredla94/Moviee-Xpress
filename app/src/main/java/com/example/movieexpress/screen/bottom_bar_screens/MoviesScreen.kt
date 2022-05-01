package com.example.movieexpress.screen.bottom_bar_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.movieexpress.R
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesScreen(
    state: HomeState
) {
    Column(
        Modifier
            .padding(20.dp)

    ) {
        Text(
            text = LocalContext.current.resources.getString(R.string.in_theater_movies),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                items(state.inTheaterMovies) { movie ->
                    VerticalUpcomingMovieCard(movie = movie)
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}