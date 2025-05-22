package com.juricaplesa.movies_data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.juricaplesa.movies_data.BuildConfig
import com.juricaplesa.movies_data.remote.MoviesApi
import com.juricaplesa.movies_data.remote.interceptors.ApiKeyQueryInterceptor
import com.juricaplesa.movies_data.remote.interceptors.AuthHeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class) //todo needs to be viewmodelcomponent later
object MoviesRemoteDataModule {

    @Provides
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideOkHttpClient(
        authHeaderInterceptor: AuthHeaderInterceptor,
        apiKeyQueryInterceptor: ApiKeyQueryInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(authHeaderInterceptor)
        .addInterceptor(apiKeyQueryInterceptor)
        .also {
            if (BuildConfig.DEBUG) {
                it.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
        }
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        json: Json,
    ): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    fun provideAuthApi(
        retrofit: Retrofit
    ): MoviesApi = retrofit.create(MoviesApi::class.java)
}