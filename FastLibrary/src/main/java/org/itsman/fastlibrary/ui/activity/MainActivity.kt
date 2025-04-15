package org.itsman.fastlibrary.ui.activity

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import org.itsman.fastlibrary.R
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityMainBinding
import org.itsman.fastlibrary.tools.log
import org.itsman.fastlibrary.viewmodel.MainActivityVM

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
//        setContent {
//            BaseAndroidTheme {
//                Show(name = "kevin",model = model)
//            }
//        }

        WindowCompat.getInsetsController(window, window.decorView)
            .hide(WindowInsetsCompat.Type.systemBars())
        bind.button.text = "hello 123"
        bind.button.setOnClickListener {
//            val a = ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
//            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isG ->
//                if (isG) {
//
//                }
//            }
            val notifServer = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                val channel =
                    NotificationChannel("test", "base", NotificationManager.IMPORTANCE_HIGH)
                notifServer.createNotificationChannel(channel)
            }
            val notifi = NotificationCompat.Builder(this, "test").setContentText("Test")
                .setContentTitle("Test")
                .setSmallIcon(R.mipmap.calories_icon)
                .setAutoCancel(true)
                .build()
            notifServer.notify(123, notifi)
        }
        bind.button.setOnClickListener {

        }
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            val notifServer = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                val channel =
                    NotificationChannel("test", "base", NotificationManager.IMPORTANCE_HIGH)
                notifServer.createNotificationChannel(channel)
            }
            val notifi = NotificationCompat.Builder(this, "test").setContentText("Test")
                .setContentTitle("Test")
                .setSmallIcon(R.mipmap.calories_icon)
                .setAutoCancel(true)
                .build()
            notifServer.notify(123, notifi)
        }.launch(Manifest.permission.POST_NOTIFICATIONS)
//        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.POST_NOTIFICATIONS),10)
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