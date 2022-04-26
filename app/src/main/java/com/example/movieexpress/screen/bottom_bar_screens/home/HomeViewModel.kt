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

    private fun <T> handleFailure(result: Resource.Failure<List<T>>) {
        state = state.copy(
            isError = result.message!!
        )
    }


    private fun getPopularMovies() {
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

    private fun getComingSoonMovies() {
        viewModelScope.launch {
            movieRepository.getUpcomingMovies()
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            state = state.copy(
                                comingSoonMovies = result.data!!
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