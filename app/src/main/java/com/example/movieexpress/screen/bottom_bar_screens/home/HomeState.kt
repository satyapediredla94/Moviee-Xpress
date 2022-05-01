package com.example.movieexpress.screen.bottom_bar_screens.home

import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie

data class HomeState(
    val topTwoFiftyMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val comingSoonMovies: List<UpcomingMovie> = emptyList(),
    val inTheaterMovies: List<UpcomingMovie> = emptyList(),
    val isLoading : Boolean = false,
    val isError: String = ""
)
