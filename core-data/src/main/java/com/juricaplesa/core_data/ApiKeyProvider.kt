package com.juricaplesa.core_data

object ApiKeyProvider {
    val accessToken: String
        get() = BuildConfig.ACCESS_TOKEN

    val apiKey: String
        get() = BuildConfig.API_KEY
}