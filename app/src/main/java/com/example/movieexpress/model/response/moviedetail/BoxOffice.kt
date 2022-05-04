package com.example.movieexpress.model.response.moviedetail

data class BoxOffice(
    val budget: String?,
    val cumulativeWorldwideGross: String?,
    val grossUSA: String?,
    val openingWeekendUSA: String?
)