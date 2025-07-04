package org.itsman.baseandroid

import android.app.Application
import org.itsman.fastlibrary.tools.log

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        log("MyApp")
    }
}