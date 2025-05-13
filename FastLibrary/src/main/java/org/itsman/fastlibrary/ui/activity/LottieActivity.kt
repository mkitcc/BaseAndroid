package org.itsman.fastlibrary.ui.activity

import android.os.Bundle
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityLottieBinding

class LottieActivity : BaseActivity(){

    lateinit var bind : ActivityLottieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLottieBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }
}