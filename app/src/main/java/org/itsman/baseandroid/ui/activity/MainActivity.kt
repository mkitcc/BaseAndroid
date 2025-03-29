package org.itsman.baseandroid.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar.LayoutParams
import org.itsman.baseandroid.R
import org.itsman.baseandroid.databinding.ActivityMainBinding
import org.itsman.baseandroid.ui.compose.Show
import org.itsman.baseandroid.viewmodel.MainActivityVM
import org.itsman.fastlibrary.theme.BaseAndroidTheme
import org.itsman.fastlibrary.tools.log

class MainActivity : BaseActivity() {

    private val model: MainActivityVM by viewModels()
    private lateinit var bind: ActivityMainBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(bind.root)
        handler = Handler(Looper.getMainLooper(), object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {

                return true
            }
        })
        setContent {
            BaseAndroidTheme {
                Show(name = "kevin",model = model)
            }
        }

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
//        bind.button.setOnClickListener {
//            //CustomDialog().show(supportFragmentManager)
//            addView()
//            bind.button.post {
//                log("" + bind.button.width)
//            }
//        }
//        bind.button.post {
//            log("" + bind.button.width)
//        }
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

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        log("attachedToWindow")
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