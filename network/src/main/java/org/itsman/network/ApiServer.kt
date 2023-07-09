package org.itsman.network

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiServer {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>

    @GET("/quotes")
    fun getQuotes2(): Observable<QuoteList>
}