package com.example.movieexpress.remote

import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie
import com.example.movieexpress.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class MovieRepositoryImpl(
    private val apiService: MovieXpressApiService
) : MovieRepository {
    override fun getTopTwoFiftyMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getTopMovies()
            emit(Resource.Success(movies.items))
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }

    }

    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getPopularMovies()
            emit(Resource.Success(movies.items))
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }

    }

    override fun getUpcomingMovies(): Flow<Resource<List<UpcomingMovie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getUpcomingMovies()
            emit(Resource.Success(movies.upcomingMovies))
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }
    }
}