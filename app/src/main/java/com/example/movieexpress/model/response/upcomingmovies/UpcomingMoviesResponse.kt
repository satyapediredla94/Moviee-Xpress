package com.example.movieexpress.model.response.upcomingmovies

data class UpcomingMoviesResponse(
    val errorMessage: String,
    val upcomingMovies: List<UpcomingMovie>
)