package com.example.movieexpress.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeScreen
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel
import com.example.movieexpress.screen.bottom_bar_screens.movies.MoviesScreen
import com.example.movieexpress.screen.bottom_bar_screens.search.SearchHomeScreen
import com.example.movieexpress.screen.bottom_bar_screens.series.SeriesScreen
import com.example.movieexpress.screen.bottom_bar_screens.settings.SettingsScreen
import com.example.movieexpress.utils.AppConstants

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    NavHost(navController, startDestination = BottomMenuItem.Home.route) {
        composable(BottomMenuItem.Home.route) {
            HomeScreen(
                state = viewModel.state,
                navController = navController
            )
        }
        composable(BottomMenuItem.Series.route) {
            viewModel.getPopularTVs()
            SeriesScreen(
                state = viewModel.state,
                navController = navController
            )
        }
        composable(BottomMenuItem.Movies.route) {
            viewModel.getInTheaterMovies()
            MoviesScreen(
                state = viewModel.state,
                navController = navController
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
        //tt0111161
        composable(
            "${AppConstants.MOVIE_DESCRIPTION}/{titleId}",
            arguments = listOf(navArgument("titleId") {
                type = NavType.StringType
                defaultValue = ""
            })
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.get("titleId")
            MovieDescription(
                movieId = movieId as String,
                viewModel = viewModel
            )
        }
    }
}