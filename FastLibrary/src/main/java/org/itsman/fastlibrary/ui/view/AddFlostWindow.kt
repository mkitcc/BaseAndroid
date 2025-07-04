package org.itsman.fastlibrary.ui.view

import android.view.WindowManager
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import org.itsman.fastlibrary.R


/**
 * 添加浮动窗口
 */
fun addView(activity: AppCompatActivity) {
    val layoutParams = WindowManager.LayoutParams().apply {
        width = LayoutParams.WRAP_CONTENT
        height = LayoutParams.WRAP_CONTENT
        flags =
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
    }
    val view = activity.layoutInflater.inflate(R.layout.flowwm, null)
    activity.windowManager.addView(view, layoutParams)
}