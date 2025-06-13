package org.itsman.fastlibrary.tools

import android.app.Activity

/**
 * 打开Assets 里的文件
 */
fun getAssets(context: Activity,name: String){

    context.assets.open(name)
}