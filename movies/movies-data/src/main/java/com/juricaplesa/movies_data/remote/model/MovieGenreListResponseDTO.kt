package com.juricaplesa.movies_data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieGenreListResponseDTO(
    val genres: List<MovieGenreDTO>,
)