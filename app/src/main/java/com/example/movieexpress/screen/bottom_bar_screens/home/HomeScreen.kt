package com.example.movieexpress.screen.bottom_bar_screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.movieexpress.R
import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie
import com.example.movieexpress.screen.bottom_bar_screens.HorizontalCard
import com.example.movieexpress.screen.bottom_bar_screens.VerticalCard

@Composable
fun HomeScreen(
    topMovies: List<Movie>,
    popularMovies: List<Movie>,
    upcomingMovies: List<UpcomingMovie>
) {
    Column(Modifier.padding(20.dp)) {
        Text(
            text = LocalContext.current.resources.getString(R.string.top_movies),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(topMovies) { movie ->
                VerticalCard(movie = movie)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = LocalContext.current.resources.getString(R.string.popular_movies),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(popularMovies) { movie ->
                VerticalCard(movie = movie)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
        Text(
            text = LocalContext.current.resources.getString(R.string.upcoming_movies),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(upcomingMovies) { movie ->
                HorizontalCard(movie = movie)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}