package com.example.movieexpress.screen.bottom_bar_screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.example.movieexpress.model.response.toptwofiftymovies.Movie
import com.example.movieexpress.model.response.upcomingmovies.UpcomingMovie

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HorizontalCard(
    navController: NavController = rememberNavController(),
    movie: UpcomingMovie
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .clickable {
            }
            .height(80.dp)
    ) {
        Row(

        ) {
            AsyncImage(
                model = movie.image, contentDescription = "",
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.FillHeight
            )
            Spacer(Modifier.width(10.dp))
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = movie.fullTitle,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
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