package org.itsman.k_library.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.itsman.k_library.databinding.DialogfragmentBaseBinding

class BaseDialog : DialogFragment() {


    private lateinit var bind: DialogfragmentBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DialogfragmentBaseBinding.inflate(inflater, container, false)
        return bind.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}