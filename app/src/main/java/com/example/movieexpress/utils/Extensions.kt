package com.example.movieexpress.utils

fun String.getUrlFromImage(): String? {
    val split = this.split("/")
    return if (split.isNotEmpty()) {
        "https://m.media-amazon.com/images/384x528/" + (split[split.size - 1])
    } else {
        null
    }
}