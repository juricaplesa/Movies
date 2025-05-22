package com.juricaplesa.movies_data

import com.juricaplesa.movies_data.remote.MoviesRemoteDataSource
import com.juricaplesa.movies_domain.MoviesRepository
import com.juricaplesa.movies_domain.model.MovieGenre
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {

    override suspend fun getGenres(): Result<List<MovieGenre>> {
        lateinit var genres: List<MovieGenre>
        moviesRemoteDataSource.getGenres()
            .onSuccess {
                genres = it.map { dto -> dto.toMovieGenre() }
            }
            .onFailure {
                return Result.failure(it)
            }

        return Result.success(genres)
    }
}