package com.juricaplesa.movies_ui.list

import com.juricaplesa.movies_domain.model.Movie

data class MoviesListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = listOf()
)
