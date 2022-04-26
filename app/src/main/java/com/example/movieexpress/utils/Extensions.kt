package com.example.movieexpress.utils

import com.example.movieexpress.remote.MovieXpressApiService

fun String.getUrlFromImage() : String? {
    val split = this.split("/")
    return if (split.isNotEmpty()) {
        "https://m.media-amazon.com/images/384x528/" + (split[split.size-1])
    } else {
        null
    }
}