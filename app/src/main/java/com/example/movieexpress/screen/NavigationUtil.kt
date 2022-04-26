package com.example.movieexpress.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
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
fun Navigation(navController: NavHostController,
               viewModel: HomeViewModel) {
    NavHost(navController, startDestination = BottomMenuItem.Home.route) {
        composable(BottomMenuItem.Home.route) {
            HomeScreen(
                topMovies = viewModel.state.topTwoFiftyMovies,
                popularMovies = viewModel.state.popularMovies,
                upcomingMovies = viewModel.state.comingSoonMovies
            )
        }
        composable(BottomMenuItem.Series.route) {
            SeriesScreen()
        }
        composable(BottomMenuItem.Movies.route) {
            MoviesScreen()
        }
        composable(BottomMenuItem.Search.route) {
            SearchScreen()
        }
        composable(BottomMenuItem.Settings.route) {
            SettingsScreen()
        }
    }
}