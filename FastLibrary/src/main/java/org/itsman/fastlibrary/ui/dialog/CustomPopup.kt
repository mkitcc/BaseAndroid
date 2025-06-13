package org.itsman.fastlibrary.ui.dialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow

object CustomPopup {

    fun show(view: View, layout: Int) {
        val bind = LayoutInflater.from(view.context).inflate(layout, null)
        val popup = PopupWindow(
            bind,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        popup.isTouchable = true
        popup.setTouchInterceptor { myv, event ->
            return@setTouchInterceptor true
        }
        popup.showAsDropDown(view, 50, 50)
    }

}