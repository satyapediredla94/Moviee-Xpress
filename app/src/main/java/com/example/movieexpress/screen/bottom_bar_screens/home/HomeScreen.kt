package com.example.movieexpress.screen.bottom_bar_screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieexpress.R
import com.example.movieexpress.screen.bottom_bar_screens.cards.HorizontalUpcomingMovieCard
import com.example.movieexpress.screen.bottom_bar_screens.cards.VerticalMovieCard

@Composable
fun HomeScreen(
    state: HomeState,
    navController: NavController
) {
    Column(
        Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = LocalContext.current.resources.getString(R.string.popular_movies),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyRow {
                items(state.popularMovies) { movie ->
                    VerticalMovieCard(
                        movie = movie,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = LocalContext.current.resources.getString(R.string.popular_tvs),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyRow {
                items(state.popularTVs) { movie ->
                    VerticalMovieCard(
                        movie = movie,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = LocalContext.current.resources.getString(R.string.upcoming_movies),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                Modifier.height((80 * 6).dp)
            ) {
                items(state.comingSoonMovies) { movie ->
                    HorizontalUpcomingMovieCard(
                        movie = movie,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}