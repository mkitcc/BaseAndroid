package org.itsman.baseandroid.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
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
        bind.button.setOnClickListener{
            CustomDialog().show(supportFragmentManager)
        }
        model.getData()
        model.data.observe(this) {
            log(it!!)
        }
//        bind.button.setOnClickListener {
//            CustomDialog().show(supportFragmentManager)
//        }
    }
}

class AA(val aa: String) {
    val bb = aa

    fun adbc() {
        val cc = aa
    }

    constructor(i: String, i2: String) : this(i) {

    }
}