package com.juricaplesa.movies_data.remote

import com.juricaplesa.movies_data.remote.model.MovieDTO
import com.juricaplesa.movies_data.remote.model.MovieGenreListResponseDTO
import com.juricaplesa.movies_data.remote.model.MovieListResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("genre/movie/list")
    suspend fun getGenres(): MovieGenreListResponseDTO

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("with_genres") genreId: Int?,
        @Query("page") page: Int
    ): MovieListResponseDTO

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int
    ): MovieDTO
}