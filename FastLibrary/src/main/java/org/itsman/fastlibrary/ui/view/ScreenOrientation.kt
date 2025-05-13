package org.itsman.fastlibrary.ui.view

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity


/**
 * 设置屏幕方向
 */
fun setScreenOrigentation(activity: AppCompatActivity) {

    val currentOrientation = activity.getResources().getConfiguration().orientation

    if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
    } else {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
    }
}