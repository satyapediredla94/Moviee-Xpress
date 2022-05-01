package com.example.movieexpress.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeScreen
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel
import com.example.movieexpress.screen.bottom_bar_screens.movies.MoviesScreen
import com.example.movieexpress.screen.bottom_bar_screens.search.SearchHomeScreen
import com.example.movieexpress.screen.bottom_bar_screens.series.SeriesScreen
import com.example.movieexpress.screen.bottom_bar_screens.settings.SettingsScreen

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
            SearchHomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(BottomMenuItem.Settings.route) {
            SettingsScreen()
        }
    }
}