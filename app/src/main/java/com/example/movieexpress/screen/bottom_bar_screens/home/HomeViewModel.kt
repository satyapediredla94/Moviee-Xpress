package com.example.movieexpress.screen.bottom_bar_screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieexpress.remote.MovieRepository
import com.example.movieexpress.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    var state by mutableStateOf(HomeState())

    init {
        getTopMovies()
    }

    private fun getTopMovies() {
        if (state.topTwoFiftyMovies.isEmpty()) {
            viewModelScope.launch {
                movieRepository.getTopTwoFiftyMovies()
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                state = state.copy(
                                    topTwoFiftyMovies = result.data!!
                                )
                                getPopularMovies()
                            }
                            is Resource.Failure -> {
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }

    private fun <T> handleFailure(result: Resource.Failure<List<T>>) {
        state = state.copy(
            isError = result.message!!
        )
    }


    private fun getPopularMovies() {
        if (state.popularMovies.isEmpty()) {
            viewModelScope.launch {
                movieRepository.getPopularMovies()
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                state = state.copy(
                                    popularMovies = result.data!!
                                )
                                getComingSoonMovies()
                            }
                            is Resource.Failure -> {
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }

    private fun getComingSoonMovies() {
        if (state.comingSoonMovies.isEmpty()) {
            viewModelScope.launch {
                movieRepository.getUpcomingMovies()
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                state = state.copy(
                                    comingSoonMovies = result.data!!
                                )
                                getInTheaterMovies()
                                getPopularTVs()
                            }
                            is Resource.Failure -> {
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }

    fun getInTheaterMovies() {
        if (state.inTheaterMovies.isEmpty()) {
            Timber.d("In Theater movies are empty. So making API call")
            viewModelScope.launch {
                movieRepository.getInTheaterMovies()
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                Timber.d("In Theater movies service returned Success")
                                state = state.copy(
                                    inTheaterMovies = result.data!!
                                )
                            }
                            is Resource.Failure -> {
                                Timber.d("In Theater movies service returned Failure")
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                Timber.d("In Theater movies service returned Loading as ${result.isLoading}")
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }

    fun getPopularTVs() {
        if (state.popularTVs.isEmpty()) {
            viewModelScope.launch {
                movieRepository.getPopularTVs()
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                state = state.copy(
                                    popularTVs = result.data!!
                                )
                                getTopSeries()
                            }
                            is Resource.Failure -> {
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }


    private fun getTopSeries() {
        if (state.topTwoFiftySeries.isEmpty()) {
            viewModelScope.launch {
                movieRepository.getTopTwoFiftySeries()
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                state = state.copy(
                                    topTwoFiftySeries = result.data!!
                                )
                            }
                            is Resource.Failure -> {
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }

    fun getMovieOrSeries(searchString: String) {
        if (state.searchResponse.isEmpty() || isSearchCriteriaMatched(searchString)) {
            viewModelScope.launch {
                movieRepository.getMovieOrSeriesInfo(searchString)
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                state = state.copy(
                                    searchResponse = result.data!!
                                )
                            }
                            is Resource.Failure -> {
                                handleFailure(result)
                            }
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
            }
        }
    }

    private fun isSearchCriteriaMatched(searchString: String): Boolean {
        return state.searchResponse.isNotEmpty() && !state.searchResponse[0].title.contains(searchString)
    }


}