package org.itsman.fastlibrary.tools

import android.app.Activity
import org.apache.poi.sl.draw.geom.Context

fun getAssets(context: Activity,name: String){

    context.assets.open(name)
}