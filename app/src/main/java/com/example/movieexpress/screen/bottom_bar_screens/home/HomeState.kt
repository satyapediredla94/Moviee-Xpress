package com.example.movieexpress.screen.bottom_bar_screens.home

import com.example.movieexpress.model.response.searchresponse.SearchResponse
import com.example.movieexpress.model.response.searchresponse.SearchResult
import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie

data class HomeState(
    val topTwoFiftyMovies: List<Movie> = emptyList(),
    val topTwoFiftySeries: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val popularTVs: List<Movie> = emptyList(),
    val comingSoonMovies: List<UpcomingMovie> = emptyList(),
    val inTheaterMovies: List<UpcomingMovie> = emptyList(),
    val searchResponse: List<SearchResult> = emptyList(),
    val isLoading: Boolean = false,
    val isError: String = ""
)
