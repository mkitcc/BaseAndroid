package org.itsman.fastlibrary.tools

import android.util.Log
import retrofit2.http.HEAD

class Log {
    companion object {
        const val HEAD = "FastLibrary"
    }

    fun e(str: String) {
        Log.e(HEAD, str)
    }
}