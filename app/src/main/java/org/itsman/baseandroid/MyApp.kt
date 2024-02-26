package org.itsman.baseandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.itsman.fastlibrary.tools.log

@HiltAndroidApp
class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        log("MyApp")
    }
}