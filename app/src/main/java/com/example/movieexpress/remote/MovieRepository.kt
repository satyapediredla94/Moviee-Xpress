package com.example.movieexpress.remote

import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie
import com.example.movieexpress.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getTopTwoFiftyMovies(): Flow<Resource<List<Movie>>>
    fun getPopularMovies(): Flow<Resource<List<Movie>>>
    fun getUpcomingMovies(): Flow<Resource<List<UpcomingMovie>>>

}