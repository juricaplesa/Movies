package com.juricaplesa.movies_data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponseDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)