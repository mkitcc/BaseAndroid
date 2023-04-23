package org.itsman.baseandroid.network

import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}