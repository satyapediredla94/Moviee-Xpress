package com.example.movieexpress.di

import com.example.movieexpress.remote.MovieRepository
import com.example.movieexpress.remote.MovieRepositoryImpl
import com.example.movieexpress.remote.MovieXpressApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService() : MovieXpressApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(MovieXpressApiService.BASE_URL)
        .build()
        .create(MovieXpressApiService::class.java)


    @Provides
    @Singleton
    fun getMovieRepository(
        apiService: MovieXpressApiService
    ) : MovieRepository = MovieRepositoryImpl(apiService = apiService)

}