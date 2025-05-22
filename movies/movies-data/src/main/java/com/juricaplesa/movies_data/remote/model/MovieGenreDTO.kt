package com.juricaplesa.movies_data.remote.model

import com.juricaplesa.movies_domain.model.MovieGenre
import kotlinx.serialization.Serializable

@Serializable
data class MovieGenreDTO(
    val id: Int,
    val name: String,
) {

    fun toMovieGenre() = MovieGenre(
        id = id,
        name = name
    )
}
