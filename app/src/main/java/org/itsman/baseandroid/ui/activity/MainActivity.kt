package org.itsman.baseandroid.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import org.itsman.baseandroid.R
import org.itsman.baseandroid.databinding.ActivityMainBinding
import org.itsman.baseandroid.ui.compose.Counter
import org.itsman.baseandroid.ui.compose.Show
import org.itsman.baseandroid.viewmodel.MainActivityVM
import org.itsman.fastlibrary.dialog.CustomDialog
import org.itsman.fastlibrary.theme.BaseAndroidTheme
import org.itsman.fastlibrary.tools.log
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : BaseActivity() {

    private val model: MainActivityVM by viewModels()
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
//        setContent {
//            BaseAndroidTheme {
//                Show(name = "kevin", model = model)
//            }
//        }

//        WindowCompat.getInsetsController(window, window.decorView)
//            .hide(WindowInsetsCompat.Type.systemBars())
//        bind.button.text = "hello 123"
//        model.data.observe(this) {
//            bind.tvText.text = it
//            CustomDialog().show(supportFragmentManager)
//        }
        bind.button.setOnClickListener {
            //CustomDialog().show(supportFragmentManager)
            addView()
        }
        bind.button.post {
            log("" + bind.button.width)
        }
        bind.button.viewTreeObserver.addOnGlobalLayoutListener {

        }
        model.getData()
        model.data.observe(this) {
            log(it!!)
        }
        log("onCreate")
    }

    private fun addView() {
        val layoutParams = WindowManager.LayoutParams().apply {
            width = LayoutParams.WRAP_CONTENT
            height = LayoutParams.WRAP_CONTENT
            flags =
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        }
        val view = layoutInflater.inflate(R.layout.flowwm, null)
        windowManager.addView(view, layoutParams)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        log("configChanged")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }
}