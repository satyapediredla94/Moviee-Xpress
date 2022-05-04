package com.example.movieexpress.model.response.searchresponse

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val errorMessage: String,
    val expression: String,
    @SerializedName(value = "results")
    val searchResults: List<SearchResult>?,
    val searchType: String
)