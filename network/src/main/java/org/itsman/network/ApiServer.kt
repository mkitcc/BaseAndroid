package org.itsman.network

import org.itsman.network.entity.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface ApiServer {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>

    @GET("/quotes")
    suspend fun getQuotes2(): QuoteList
}