package org.itsman.fastlibrary.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.Flow

class HttpClient(url:String) {
//    private const val baseUrl = "https://www.wanandroid.com"
    private var serverMap = mutableMapOf<Class<out Any>, Any>()

    private val mOkHttp = OkHttpClient.Builder().build();
    private val mRetrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(mOkHttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mApiServer = mRetrofit.create(ApiServer::class.java)


    fun getApi(): ApiServer {
        return mApiServer
    }

    fun <T : Any> getApi(clazz: Class<T>): T {
        if (!serverMap.containsKey(clazz)) {
            serverMap[clazz] = mRetrofit.create(clazz)
        }
        return serverMap[clazz] as T
    }

    suspend fun <T> Retrofit.request(call: suspend () -> ResponseResult<T>) = flow {
        val response = call()
        if (response.isSuccess()) {
            emit(RequestResult.Success(response))
        } else {
            emit(RequestResult.Error(response.errorCode, response.errorMsg))
        }
    }.flowOn(Dispatchers.IO).catch { emit(RequestResult.Error(-1, it.message)) }
}

