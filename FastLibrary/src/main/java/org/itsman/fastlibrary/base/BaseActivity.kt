package org.itsman.fastlibrary.base

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {


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