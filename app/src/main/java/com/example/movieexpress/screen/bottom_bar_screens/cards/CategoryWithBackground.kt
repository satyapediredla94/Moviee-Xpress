package com.example.movieexpress.screen.bottom_bar_screens.cards

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryCard(
    category: String,
    modifier: Modifier
) {
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
        Text(
            text = category,
            style = MaterialTheme.typography.body1,
            modifier = modifier
        )
    }
}