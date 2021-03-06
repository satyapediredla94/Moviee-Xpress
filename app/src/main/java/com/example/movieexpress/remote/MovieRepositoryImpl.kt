package com.example.movieexpress.remote

import com.example.movieexpress.model.response.moviedetail.MovieDetail
import com.example.movieexpress.model.response.searchresponse.SearchResult
import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie
import com.example.movieexpress.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException

class MovieRepositoryImpl(
    private val apiService: MovieXpressApiService
) : MovieRepository {
    override fun getTopTwoFiftyMovies(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getTopMovies()
            if (movies.errorMessage.isNotEmpty()) {
                emit(Resource.Failure(message = movies.errorMessage))
            } else {
                movies.items?.let {
                    emit(Resource.Success(movies.items))
                }
            }
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }

    }

    override fun getTopTwoFiftySeries(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getTopSeries()
            if (movies.errorMessage.isNotEmpty()) {
                emit(Resource.Failure(message = movies.errorMessage))
            } else {
                movies.items?.let {
                    emit(Resource.Success(movies.items))
                }
            }
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
            if (movies.errorMessage.isNotEmpty()) {
                emit(Resource.Failure(message = movies.errorMessage))
            } else {
                movies.items?.let {
                    emit(Resource.Success(movies.items))
                }
            }
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }

    }


    override fun getPopularTVs(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getPopularTVs()
            if (movies.errorMessage.isNotEmpty()) {
                emit(Resource.Failure(message = movies.errorMessage))
            } else {
                movies.items?.let {
                    emit(Resource.Success(movies.items))
                }
            }
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }

    }

    override fun getUpcomingMovies(): Flow<Resource<List<UpcomingMovie>>> = channelFlow {
        send(Resource.Loading(true))
        try {
            val movies = apiService.getUpcomingMovies()
            Timber.d("Upcoming movies from service: ${movies.upcomingMovies?.size}")
            if (movies.errorMessage.isNotEmpty()) {
                send(Resource.Failure(message = movies.errorMessage))
            } else {
                movies.upcomingMovies?.let {
                    Timber.d("Upcoming movies from service: ${it.size}")
                    send(Resource.Success(movies.upcomingMovies))
                }
            }
            send(Resource.Loading(false))
        } catch (e: IOException) {
            send(Resource.Failure(null, "Something went wrong at Server"))
            send(Resource.Loading(false))
        } catch (e: Exception) {
            send(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            send(Resource.Loading(false))
        }
    }

    override fun getInTheaterMovies(): Flow<Resource<List<UpcomingMovie>>> = flow {
        emit(Resource.Loading(true))
        try {
            val movies = apiService.getInTheaterMovies()
            Timber.d("Upcoming movies from service: ${movies.upcomingMovies?.size}")
            if (movies.errorMessage.isNotEmpty()) {
                emit(Resource.Failure(message = movies.errorMessage))
            } else {
                movies.upcomingMovies?.let {
                    Timber.d("Upcoming movies from service: ${it.size}")
                    emit(Resource.Success(movies.upcomingMovies))
                }
            }
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }
    }

    override fun getMovieOrSeriesInfo(searchString: String): Flow<Resource<List<SearchResult>>> =
        flow {
            emit(Resource.Loading(true))
            try {
                val movies = apiService.getMovieOrSeriesInfo(searchString)
                Timber.d("Upcoming movies from service: ${movies.searchResults?.size}")
                if (movies.errorMessage.isNotEmpty()) {
                    emit(Resource.Failure(message = movies.errorMessage))
                } else {
                    movies.searchResults?.let {
                        Timber.d("Upcoming movies from service: ${it.size}")
                        emit(Resource.Success(movies.searchResults))
                    }
                }
                emit(Resource.Loading(false))
            } catch (e: IOException) {
                emit(Resource.Failure(null, "Something went wrong at Server"))
                emit(Resource.Loading(false))
            } catch (e: Exception) {
                emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
                emit(Resource.Loading(false))
            }
        }

    override fun getMovieDetail(titleId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            val movieDetails = apiService.getMovieDetail(titleId = titleId)
            Timber.d("Movie Details : API Finished")
            if (!movieDetails.errorMessage.isNullOrEmpty()) {
                emit(Resource.Failure(message = movieDetails.errorMessage))
            } else {
                Timber.d("Movie Details: Error message is null or empty")
                emit(Resource.Success(data = movieDetails))
            }
        } catch (e: IOException) {
            emit(Resource.Failure(null, "Something went wrong at Server"))
            emit(Resource.Loading(false))
        } catch (e: Exception) {
            emit(Resource.Failure(null, "Something went wrong. Please try again momentarily"))
            emit(Resource.Loading(false))
        }
    }
}