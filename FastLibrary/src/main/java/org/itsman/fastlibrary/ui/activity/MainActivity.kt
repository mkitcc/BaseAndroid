package org.itsman.fastlibrary.ui.activity

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityMainBinding
import org.itsman.fastlibrary.tools.log
import org.itsman.fastlibrary.ui.viewmodel.MainActivityVM


class MainActivity : BaseActivity() {

    private val model: MainActivityVM by viewModels()
    private lateinit var bind: ActivityMainBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        handler = Handler(Looper.getMainLooper(), object : Handler.Callback {
            override fun handleMessage(msg: Message): Boolean {

                return true
            }
        })
        bind.button.text = "hello 123"
        bind.button.setOnClickListener {
//            val dialog = CustomDialog(CustomDialog.StyleBottom) { inflater, viewGroup ->
//                val view = inflater.inflate(R.layout.dialog_test, viewGroup)
//                return@CustomDialog view
//            }
//            dialog.show(supportFragmentManager)

//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            val currentOrientation = getResources().getConfiguration().orientation

            if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            }
        }
        bind.tvText
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.data.collect {
                    bind.tvContent.text = it
                }
            }
        }
//        startActivity(Intent(this, IMEActivity::class.java))
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