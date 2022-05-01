package com.example.movieexpress.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieexpress.screen.bottom_bar_screens.movies.MoviesScreen
import com.example.movieexpress.screen.bottom_bar_screens.search.SearchScreen
import com.example.movieexpress.screen.bottom_bar_screens.series.SeriesScreen
import com.example.movieexpress.screen.bottom_bar_screens.settings.SettingsScreen
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeScreen
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    NavHost(navController, startDestination = BottomMenuItem.Home.route) {
        composable(BottomMenuItem.Home.route) {
            HomeScreen(
                state = viewModel.state
            )
        }
        composable(BottomMenuItem.Series.route) {
            viewModel.getPopularTVs()
            SeriesScreen(state = viewModel.state)
        }
        composable(BottomMenuItem.Movies.route) {
            viewModel.getInTheaterMovies()
            MoviesScreen(
                state = viewModel.state
            )
        }
        composable(BottomMenuItem.Search.route) {
            SearchScreen()
        }
        composable(BottomMenuItem.Settings.route) {
            SettingsScreen()
        }
    }
}