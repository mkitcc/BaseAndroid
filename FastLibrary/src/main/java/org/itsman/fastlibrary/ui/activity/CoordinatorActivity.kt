package org.itsman.fastlibrary.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ConcatAdapter
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityCoordinatorBinding
import org.itsman.fastlibrary.tools.permission.RequestPermission
import org.itsman.fastlibrary.tools.permission.RequestPermissionAc
import org.itsman.fastlibrary.ui.adapter.SimpleAdapter
import org.itsman.fastlibrary.ui.view.addView

class CoordinatorActivity : BaseActivity() {


    lateinit var bind: ActivityCoordinatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityCoordinatorBinding.inflate(layoutInflater)
        setContentView(bind.root)
        useInsetsMargin(bind.root)
        initView()
        initData()
    }

    fun initView() {
        bind.root.setOnClickListener {
//            bind.appbarTitle.setExpanded(false)
        }
    }

    fun initData() {
        bind.recycler.adapter = SimpleAdapter()
        bind.recycler.adapter = ConcatAdapter(SimpleAdapter())
        bind.ivTop.setOnClickListener {
            if (RequestPermission.checkDrawOverlays(this)){
                addView(this)
                finish()
            }
        }
//        bind.recycler.postDelayed({
//            addView(this)
//        },1000)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        bind.appbarTitle.setExpanded(false)
        return super.dispatchTouchEvent(ev)
    }

}