package com.example.movieexpress.remote

import com.example.movieexpress.model.response.moviedetail.MovieDetail
import com.example.movieexpress.model.response.searchresponse.SearchResponse
import com.example.movieexpress.model.response.toptwofiftymovies.TopTwoFiftyMoviesResponse
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieXpressApiService {

    companion object {
        //                const val API_KEY = "k_3xzdnxal"
        const val API_KEY = "k_fpkihu7b"
        const val BASE_URL = "https://imdb-api.com/en/API/"
    }

    @GET("Top250Movies/$API_KEY")
    suspend fun getTopMovies(): TopTwoFiftyMoviesResponse

    @GET("Top250TVs/$API_KEY")
    suspend fun getTopSeries(): TopTwoFiftyMoviesResponse

    @GET("MostPopularMovies/$API_KEY")
    suspend fun getPopularMovies(): TopTwoFiftyMoviesResponse

    @GET("MostPopularTVs/$API_KEY")
    suspend fun getPopularTVs(): TopTwoFiftyMoviesResponse

    @GET("ComingSoon/$API_KEY")
    suspend fun getUpcomingMovies(): UpcomingMoviesResponse

    @GET("InTheaters/$API_KEY")
    suspend fun getInTheaterMovies(): UpcomingMoviesResponse

    @GET("Search/$API_KEY/{search_string}")
    suspend fun getMovieOrSeriesInfo(
        @Path("search_string") searchString: String
    ): SearchResponse

    @GET("Title/$API_KEY/{titleId}")
    suspend fun getMovieDetail(
        @Path("titleId") titleId: String
    ): MovieDetail

}