package org.itsman.fastlibrary.ui.activity

import android.os.Bundle
import androidx.compose.ui.layout.IntrinsicMeasurable
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityImeBinding
import org.itsman.fastlibrary.databinding.ActivityMainBinding

class IMEActivity : BaseActivity() {

    lateinit var bind: ActivityImeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityImeBinding.inflate(layoutInflater)
        setContentView(bind.root)
        useInsetsMargin(bind.root)
    }
}