package com.example.movieexpress.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieexpress.screen.bottom_bar_screens.MoviesScreen
import com.example.movieexpress.screen.bottom_bar_screens.SearchScreen
import com.example.movieexpress.screen.bottom_bar_screens.SeriesScreen
import com.example.movieexpress.screen.bottom_bar_screens.SettingsScreen
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