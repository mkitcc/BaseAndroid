package org.itsman.baseandroid.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import org.itsman.baseandroid.databinding.ActivityMainBinding
import org.itsman.baseandroid.viewmodel.MainActivityVM

class MainActivity : BaseActivity() {

    private val model: MainActivityVM by viewModels()
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        WindowCompat.getInsetsController(window, window.decorView)
            .hide(WindowInsetsCompat.Type.systemBars())
        bind.button.text = "hello 123"
        model.getData()
    }
}
