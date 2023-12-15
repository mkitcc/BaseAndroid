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
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : BaseActivity() {

    //    private val model: MainActivityVM by viewModels()
//    private var aa: String by MyTest()
//    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        bind = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(bind.root)
        setContent {
            BaseAndroidTheme {
                Show(name = "kevin")
            }
        }

//        WindowCompat.getInsetsController(window, window.decorView)
//            .hide(WindowInsetsCompat.Type.systemBars())
//        bind.button.text = "hello 123"
//        model.data.observe(this) {
//            bind.tvText.text = it
//            CustomDialog().show(supportFragmentManager)
//        }
//        model.getData()
//        bind.button.setOnClickListener {
//            CustomDialog().show(supportFragmentManager)
//        }
    }
}


class MyTest : ReadWriteProperty<MainActivity, String> {
    override fun getValue(thisRef: MainActivity, property: KProperty<*>): String {
        return "Hello"
    }

    override fun setValue(thisRef: MainActivity, property: KProperty<*>, value: String) {

    }

}