package org.itsman.fastlibrary.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import org.itsman.fastlibrary.R

/**
 *     需求
 * 可以自定义view
 * 可以自定义窗口位置
 * 自定义窗口的margin
 * 可以自定义窗口动画
 * 可以自定义窗口背景 (是不是有黑色蒙层)
 *
 */
class CustomDialog(
    val getView: (LayoutInflater, ViewGroup?) -> View,
    val locale: Int = Gravity.CENTER,
) : DialogFragment() {


    companion object {
        const val TAG = "CustomDialog"
    }

    lateinit var layout: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        val window = dialog.window
        window?.let {
            val ll = window.attributes
            ll.gravity= locale
            ll.verticalMargin=0f
            ll.dimAmount=1f
            ll.width= ViewGroup.LayoutParams.MATCH_PARENT
            ll.height= ViewGroup.LayoutParams.MATCH_PARENT
            window.attributes=ll
            window.decorView.setPadding(0,0,0,0)
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout = getView(inflater, container)
        return layout
    }


    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }
}