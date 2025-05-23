package com.juricaplesa.movies_domain

import com.juricaplesa.movies_domain.model.Movie
import com.juricaplesa.movies_domain.model.MovieGenre

interface MoviesRepository {
    suspend fun getMovies(genreId: Int): Result<List<Movie>>

    suspend fun requestMoviesNextPage(): Result<Unit>

    suspend fun getGenres(): Result<List<MovieGenre>>
}