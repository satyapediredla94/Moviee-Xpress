package com.example.movieexpress.model.response.upcomingmovies

import com.google.gson.annotations.SerializedName

data class UpcomingMoviesResponse(
    val errorMessage: String,
    @SerializedName(value = "items")
    val upcomingMovies: List<UpcomingMovie>?
)