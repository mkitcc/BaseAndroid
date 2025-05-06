package org.itsman.fastlibrary.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import org.itsman.fastlibrary.GlobalConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class HttpClient11(url: String) {
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

    suspend fun <T> Retrofit.request(call: suspend () -> Response<T>) = flow {
        val response = call()
        if (response.isSuccess()) {
            emit(HttpResult.Success(response))
        } else {
            emit(HttpResult.Error(response.errorCode, response.errorMsg))
        }
    }.flowOn(Dispatchers.IO).catch { emit(HttpResult.Error(-1, it.message)) }
}

object HttpClient {
    private val timeout = 10000L
    private val mOkHttp: OkHttpClient
    private val retrofit: Retrofit

    init {
        //创建okhttp
        mOkHttp = OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.MILLISECONDS)
            .readTimeout(timeout, TimeUnit.MILLISECONDS)
            .writeTimeout(timeout, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(GlobalConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttp)
            .build()
    }

    fun <T> createApi(api: Class<T>): T {
        return retrofit.create<T>(api)
    }

    val apiserver: ApiServer by lazy {
        retrofit.create<ApiServer>(ApiServer::class.java)
    }
}

