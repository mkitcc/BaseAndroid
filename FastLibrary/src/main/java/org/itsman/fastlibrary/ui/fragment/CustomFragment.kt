package org.itsman.fastlibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import org.itsman.fastlibrary.base.BaseFragment
import kotlin.reflect.KClass

class CustomFragment(val layout: Int, val callback: ((View) -> Unit)? = null) : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(layout, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        callback?.invoke(view)
    }
}