package org.itsman.baseandroid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpServer {
    private const val baseUrl = "https://quotable.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}