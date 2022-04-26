package com.example.movieexpress.model.response.toptwofiftymovies

data class TopTwoFiftyMoviesResponse(
    val errorMessage: String,
    val items: List<Movie>
)