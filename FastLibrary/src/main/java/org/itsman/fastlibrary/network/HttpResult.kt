package org.itsman.fastlibrary.network


data class Response<T>(
    val errorCode: Int = -9999,
    val errorMsg: String? = "",
    val data: T? = null
) {
    companion object {
        suspend fun <T> call(api: suspend () -> Response<T>): HttpResult<T?> {
            val respone = api()
            return (if (respone.isSuccess()) {
                HttpResult.Success(respone.data)
            } else {
                HttpResult.Error(errorCode = respone.errorCode, errorMsg = respone.errorMsg)
            })
        }
    }

    fun isSuccess(): Boolean {
        return errorCode == 0
    }

    fun result(): HttpResult<T?> {
        return (if (this.isSuccess()) {
            HttpResult.Success(this.data)
        } else {
            HttpResult.Error(errorCode = this.errorCode, errorMsg = this.errorMsg)
        })
    }
}


sealed class HttpResult<out T> {
    data class Success<out T>(val data: T) : HttpResult<T>()
    data class Error(val errorCode: Int = -1, val errorMsg: String? = "") : HttpResult<Nothing>()
}
