package org.itsman.baseandroid.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import org.itsman.baseandroid.databinding.ActivityMainBinding
import org.itsman.baseandroid.viewmodel.MainActivityVM
import org.itsman.fastlibrary.dialog.CustomDialog
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : BaseActivity() {

    private val model: MainActivityVM by viewModels()
    private var aa:String by MyTest()
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        WindowCompat.getInsetsController(window, window.decorView)
            .hide(WindowInsetsCompat.Type.systemBars())
        bind.button.text = "hello 123"
        model.data.observe(this) {
            bind.tvText.text = it
            CustomDialog().show(supportFragmentManager)
        }
        model.getData()
    }
}


class MyTest:ReadWriteProperty<MainActivity,String>{
    override fun getValue(thisRef: MainActivity, property: KProperty<*>): String {
        return "Hello"
    }

    override fun setValue(thisRef: MainActivity, property: KProperty<*>, value: String) {

    }

}