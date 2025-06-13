package org.itsman.fastlibrary.tools

import android.content.Context
import java.io.File


/**
 * 把字符串写入文件
 */
fun writeToFile(context: Context, file: File? = null, content: String = "") {
    var log: File? = file
    if (log == null) {
        val path = context.externalCacheDir
        log = File(path?.path + File.separator + "aa.txt")
    }
    log.writeText(content)
}