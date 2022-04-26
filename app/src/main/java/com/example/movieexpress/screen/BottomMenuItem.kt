package com.example.movieexpress.screen

import androidx.annotation.DrawableRes
import com.example.movieexpress.R
import com.example.movieexpress.utils.UIConstants

sealed class BottomMenuItem(val route: String, @DrawableRes val icon: Int, val title: String) {
    object Home : BottomMenuItem(UIConstants.HOME, R.drawable.ic_home, UIConstants.HOME)
    object Search : BottomMenuItem(UIConstants.SEARCH, R.drawable.ic_search, UIConstants.SEARCH)
    object Movies : BottomMenuItem(UIConstants.MOVIES, R.drawable.ic_movie, UIConstants.MOVIES)
    object Series : BottomMenuItem(UIConstants.SERIES, R.drawable.ic_series, UIConstants.SERIES)
    object Settings : BottomMenuItem(UIConstants.SETTINGS, R.drawable.ic_settings, UIConstants.SETTINGS)
}