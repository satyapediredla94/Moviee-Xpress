package com.example.movieexpress.model.response.toptwofiftymovies

data class Movie(
    val crew: String,
    val fullTitle: String,
    val id: String,
    val imDbRating: String,
    val imDbRatingCount: String,
    val image: String,
    val rank: String,
    val title: String,
    val year: String
)