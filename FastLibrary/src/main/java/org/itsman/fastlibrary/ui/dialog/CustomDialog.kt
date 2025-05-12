package org.itsman.fastlibrary.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
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
    val style: Int = StyleBottom,
    val getView: (LayoutInflater, ViewGroup?) -> View
) : DialogFragment() {


    companion object {
        const val TAG = "CustomDialog"
        const val StyleBottom = 1
    }

    var dimAmount: Int = 0
    lateinit var layout: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext(), R.style.CustomDialog)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (style) {
            StyleBottom -> styleBottom()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }

    fun show(manager: FragmentManager) {
        show(manager, TAG)
    }

    private fun styleBottom() {
        dialog?.window?.apply {
            val ll = attributes
            ll.gravity = Gravity.BOTTOM
            ll.dimAmount = 0f
            ll.width = ViewGroup.LayoutParams.MATCH_PARENT
            ll.height = ViewGroup.LayoutParams.WRAP_CONTENT
            attributes = ll
            decorView.setPadding(0, 0, 0, 0)
            setWindowAnimations(R.style.CustomDialogAnim)
        }
    }
}