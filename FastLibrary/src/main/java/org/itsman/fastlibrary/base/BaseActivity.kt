package org.itsman.fastlibrary.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewbinding.ViewBinding

open class BaseActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
    }

    //为用户的view 添加padding ,不让systembar 盖住
    fun useInsetsMargin(view: View) {
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBar = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBar.left, systemBar.top, systemBar.right, systemBar.bottom)
            return@setOnApplyWindowInsetsListener insets
        }
    }

    fun hideSystemBar() {
        WindowCompat.getInsetsController(window, window.decorView)
            .hide(WindowInsetsCompat.Type.statusBars())
        WindowCompat.getInsetsController(window, window.decorView)
            .hide(WindowInsetsCompat.Type.navigationBars())
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