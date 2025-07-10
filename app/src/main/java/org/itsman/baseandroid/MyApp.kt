package org.itsman.baseandroid

import android.app.Application
import org.itsman.fastlibrary.GlobalConfig
import org.itsman.fastlibrary.tools.log

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        "MyApp".log()
        GlobalConfig.AppContext = this
    }
}