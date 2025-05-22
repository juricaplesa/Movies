package com.juricaplesa.movies_domain

import com.juricaplesa.movies_domain.model.MovieGenre

interface MoviesRepository {
    suspend fun getGenres(): Result<List<MovieGenre>>
}