package org.itsman.fastlibrary.tools

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context


/**
 * 复制文本到系统剪切板
 */
fun copyText(context: Context,str:String){
    val cliop = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val data = ClipData.newPlainText("label",str)
    cliop.setPrimaryClip(data)
}