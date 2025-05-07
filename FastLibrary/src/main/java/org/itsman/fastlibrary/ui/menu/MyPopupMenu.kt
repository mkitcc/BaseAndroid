package org.itsman.fastlibrary.ui.menu

import android.content.Context
import android.view.MenuInflater
import android.view.View
import android.widget.PopupMenu
import org.itsman.fastlibrary.R


//添加菜单
fun popupMenu(context: Context,anchor: View){
    val popup = PopupMenu(context, anchor)
    val inflater: MenuInflater = popup.menuInflater
    inflater.inflate(R.menu.main, popup.menu)
    popup.show()
}