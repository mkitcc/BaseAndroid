package org.itsman.fastlibrary.network


data class ResponseResult<T>(
    val errorCode: Int = -9999,
    val errorMsg: String? = "",
    val data: T? = null
) {
    fun isSuccess(): Boolean {
        return errorCode == 0
    }

}

sealed class RequestResult<out T> {
    data class Success<out T>(val data: T) : RequestResult<T>()
    data class Error(val errorCode: Int = -1, val errorMsg: String? = "") : RequestResult<Nothing>()
}