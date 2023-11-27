package org.itsman.k_library.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Flow

object HttpClient {
    private const val baseUrl = "https://www.wanandroid.com"

    private val mOkHttp = OkHttpClient.Builder().build();
    private val mRetrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(mOkHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val mApiServer = mRetrofit.create(ApiServer::class.java)


    fun getApi(): ApiServer {
        return mApiServer
    }

    suspend fun <T> request(call: suspend () -> ResponseResult<T>) = flow {
        val response = call.invoke()
        if (response.isSuccess()) {
            emit(RequestResult.Success(response))
        } else {
            emit(RequestResult.Error(response.errorCode, response.errorMsg))
        }

    }.flowOn(Dispatchers.IO).catch { emit(RequestResult.Error(-1, it.message)) }

}

