package org.itsman.baseandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.itsman.fastlibrary.tools.FLog

@HiltAndroidApp
class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        FLog.e("MyApp")
    }
}