package com.juricaplesa.movies_data.remote

import com.juricaplesa.movies_data.remote.model.MovieDTO
import com.juricaplesa.movies_data.remote.model.MovieGenreDTO
import com.juricaplesa.movies_data.remote.model.MovieListResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val moviesApi: MoviesApi
) {

    suspend fun getGenres(): Result<List<MovieGenreDTO>> = withContext(Dispatchers.IO) {
        return@withContext try {
            Result.success(moviesApi.getGenres().genres)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    suspend fun getMovies(genreId: Int, page: Int): Result<MovieListResponseDTO> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                Result.success(
                    moviesApi.getMovies(
                        genreId = genreId,
                        page = page
                    )
                )
            } catch (exception: Exception) {
                Result.failure(exception)
            }
        }

    suspend fun getMovieDetails(movieId: Int): Result<MovieDTO> = withContext(Dispatchers.IO) {
        return@withContext try {
            Result.success(moviesApi.getMovieDetails(id = movieId))
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}