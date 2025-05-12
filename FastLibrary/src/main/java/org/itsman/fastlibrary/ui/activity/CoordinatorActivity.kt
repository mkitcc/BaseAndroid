package org.itsman.fastlibrary.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityCoordinatorBinding

class CoordinatorActivity : BaseActivity() {


    lateinit var bind: ActivityCoordinatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCoordinatorBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.root.setOnClickListener {
            bind.appbarTitle.setExpanded(false)
        }
        val windowInsets = ViewCompat.getRootWindowInsets(window.decorView)
        val inset = windowInsets?.getInsets(WindowInsetsCompat.Type.statusBars())
        Log.i("CoordinatorActivity",inset?.top.toString())
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        bind.appbarTitle.setExpanded(false)
        return super.dispatchTouchEvent(ev)
    }

}