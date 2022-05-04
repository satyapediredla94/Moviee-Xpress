package com.example.movieexpress.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieexpress.screen.bottom_bar_screens.cards.CategoryCard
import com.example.movieexpress.screen.bottom_bar_screens.home.HomeViewModel


@Composable
fun MovieDescription(
    navController: NavController,
    movieId: String?,
    viewModel: HomeViewModel
) {
    movieId?.let {
        viewModel.getMovieDetails(movieId)
        val state = viewModel.state
        val movie = state.movieDetail
        movie?.let {
            Column(
                Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    AsyncImage(
                        model = movie.image,
                        contentDescription = movie.title,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    Surface(
                        color = Color.Black.copy(0.7f),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AsyncImage(
                            model = movie.image,
                            contentDescription = movie.title,
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.fullTitle,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(4.dp)
                )
                movie.directors?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = LocalContext.current.resources.getString(com.example.movieexpress.R.string.director),
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = it,
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
                movie.imDbRating?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        Modifier.padding(4.dp)
                    ) {

                        Text(
                            text = LocalContext.current.resources.getString(com.example.movieexpress.R.string.rating),
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = it,
                            style = MaterialTheme.typography.body1
                        )
                        Text(
                            text = " | ",
                            style = MaterialTheme.typography.body1
                        )
                        Text(
                            text = "${movie.imDbRatingVotes} votes",
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
                movie.genreList?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        val genres = it
                            if (genres.isNotEmpty()) {
                                genres.forEach {
                                    it.value?.let {
                                        CategoryCard(
                                            category = it,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }
                                }
                            }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = LocalContext.current.resources.getString(com.example.movieexpress.R.string.synopsis),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(4.dp)
                )
                movie.plot?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}