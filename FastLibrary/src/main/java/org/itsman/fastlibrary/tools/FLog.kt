package org.itsman.fastlibrary.tools

import android.util.Log

object FLog {
    const val HEAD = "FastLibrary"

    fun e(str: String) {
        Log.e(HEAD, str)
    }
}