package com.example.movieexpress.screen.bottom_bar_screens.series

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
import com.example.movieexpress.screen.bottom_bar_screens.cards.HorizontalMovieCard
import com.example.movieexpress.screen.bottom_bar_screens.cards.VerticalMovieCard
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeState

@Composable
fun SeriesScreen(
    state: HomeState,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
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
            text = LocalContext.current.resources.getString(R.string.top_two_fifty_tvs),
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                modifier = Modifier.height((80 * 6).dp)
            ) {
                items(state.topTwoFiftySeries) { movie ->
                    HorizontalMovieCard(
                        movie = movie,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}