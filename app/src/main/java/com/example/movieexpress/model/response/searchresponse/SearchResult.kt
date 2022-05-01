package com.example.movieexpress.model.response.searchresponse

data class SearchResult(
    val description: String,
    val id: String,
    val image: String,
    val resultType: String,
    val title: String
)