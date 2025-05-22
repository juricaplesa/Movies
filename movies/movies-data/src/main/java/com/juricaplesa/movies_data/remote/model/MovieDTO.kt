package com.juricaplesa.movies_data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieDTO(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val vote_average: Double,
    val release_date: String,
    val budget: Int?,
    val revenue: Int?,
)

