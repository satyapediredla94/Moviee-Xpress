package com.example.movieexpress.model.response.moviedetail

data class TvSeriesInfo(
    val creatorList: List<Creator>?,
    val creators: String?,
    val seasons: List<String>?,
    val yearEnd: String?
)