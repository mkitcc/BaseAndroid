package org.itsman.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import org.itsman.network.entity.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Flow

object HttpClient {
    private const val baseUrl = "https://quotable.io/"

    private val mOkHttp = OkHttpClient.Builder().build();
    private val mRetrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(mOkHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val mApiServer = mRetrofit.create(ApiServer::class.java)


    fun getInstance(): ApiServer {
        return mApiServer
    }

    suspend fun<T> request(call:suspend ()-> Response<T>) = flow<RequestResult<Response<T>>> {
        val response = call.invoke()
        if (response.isSuccess()){
//            emit(RequestResult.Success(response.data))
        }

    }.flowOn(Dispatchers.IO).catch { emit(RequestResult.Error(-1,it.message)) }

}

