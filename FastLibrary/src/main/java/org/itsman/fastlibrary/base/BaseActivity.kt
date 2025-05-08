package org.itsman.fastlibrary.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        WindowCompat.setDecorFitsSystemWindows(window,false)
//        ViewCompat.getWindowInsetsController(window.decorView)?.apply {
//            isAppearanceLightStatusBars=true
//        }
    }

    fun goToAc() {

    }

    //带返回值的跳转
    fun goToResultAc(i: Intent, o: (Intent) -> Unit) {
        registerForActivityResult(object : ActivityResultContract<Intent, Intent>() {
            override fun createIntent(
                context: Context,
                input: Intent
            ): Intent {
                return Intent()
            }

            override fun parseResult(
                resultCode: Int,
                intent: Intent?
            ): Intent {
                return Intent()
            }

        }, o).launch(i)
    }
}