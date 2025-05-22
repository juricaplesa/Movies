package com.juricaplesa.movies_data.di

import com.juricaplesa.movies_data.MoviesRepositoryImpl
import com.juricaplesa.movies_domain.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class) //todo needs to be viewmodelcomponent later
abstract class MoviesRepositoryModule {
    @Binds
    abstract fun bindMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository
}