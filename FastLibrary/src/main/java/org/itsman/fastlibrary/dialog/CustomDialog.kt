package org.itsman.fastlibrary.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class CustomDialog : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setMessage("警告")
            .setPositiveButton("确定"){_,_-> dismiss()}
            .create()
    }
    companion object {
        const val TAG = "CustomDialog"
        fun ins() : CustomDialog{
            val dialog = CustomDialog()
            val bundle = Bundle()
            dialog.arguments = bundle
            return CustomDialog()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }
    fun show(manager: FragmentManager){
        show(manager, TAG)
    }
}