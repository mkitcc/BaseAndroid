package org.itsman.baseandroid.network

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object HttpClient {
    private const val baseUrl = "https://quotable.io/"

    private val mHttpClient = OkHttpClient.Builder().build();
    private val mRetrofit = Retrofit.Builder().baseUrl(baseUrl).client(mHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val mApiServer = mRetrofit.create(ApiServer::class.java)


    fun getInstance(): ApiServer {
        return mApiServer
    }
}


interface ApiServer {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>

    @GET("/quotes")
    fun getQuotes2(): Observable<QuoteList>

}