package com.example.movieexpress.remote

import com.example.movieexpress.model.response.toptwofiftymovies.TopTwoFiftyMoviesResponse
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMoviesResponse
import retrofit2.http.GET

interface MovieXpressApiService {

    companion object {
        const val API_KEY = "k_j07xlx3k"
//        const val API_KEY = "k_rpepd5t5"
        const val BASE_URL = "https://imdb-api.com/en/API/"
    }

    @GET("Top250Movies/$API_KEY")
    suspend fun getTopMovies(): TopTwoFiftyMoviesResponse

    @GET("MostPopularMovies/$API_KEY")
    suspend fun getPopularMovies(): TopTwoFiftyMoviesResponse

    @GET("ComingSoon/$API_KEY")
    suspend fun getUpcomingMovies(): UpcomingMoviesResponse

}