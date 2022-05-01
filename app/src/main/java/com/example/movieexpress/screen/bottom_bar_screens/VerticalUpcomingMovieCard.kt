package com.example.movieexpress.screen.bottom_bar_screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie

@OptIn(ExperimentalCoilApi::class)
@Composable
fun VerticalUpcomingMovieCard(
    navController: NavController = rememberNavController(),
    movie: UpcomingMovie
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .clickable {
            }
            .fillMaxWidth(0.5f)
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = movie.image, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f),
                contentScale = ContentScale.FillWidth
            )
            Spacer(Modifier.height(10.dp))
            Column(Modifier.fillMaxHeight(0.25f)) {
                Text(
                    text = movie.fullTitle,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = movie.directors,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = 8.dp),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}