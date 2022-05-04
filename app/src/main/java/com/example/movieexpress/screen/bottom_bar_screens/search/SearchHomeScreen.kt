package com.example.movieexpress.screen.bottom_bar_screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieexpress.screen.bottom_bar_screens.cards.HorizontalSearchCard
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel

@Composable
fun SearchHomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    Column {
        SearchBar(viewModel)
        val state = viewModel.state
        if (state.isLoading) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.secondary,
                strokeWidth = 6.dp,
                modifier = Modifier
                    .height(30.dp)
                    .align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn {
                items(state.searchResponse) { searchResponse ->
                    HorizontalSearchCard(
                        movie = searchResponse,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


