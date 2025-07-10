package org.itsman.fastlibrary.tools

import android.util.Log

private const val HEAD = "FastLibrary"

fun String.log() {
    Log.e(HEAD, this)
}