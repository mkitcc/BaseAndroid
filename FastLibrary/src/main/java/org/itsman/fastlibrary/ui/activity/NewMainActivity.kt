package org.itsman.fastlibrary.ui.activity

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import androidx.activity.compose.setContent
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityNewMainBinding
import org.itsman.fastlibrary.ui.compose.theme.BaseAndroidTheme

class NewMainActivity : BaseActivity() {

    private lateinit var binding: ActivityNewMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityNewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        binding.myProgress.setColor(Color.RED, Color.GREEN, Color.BLUE)
        binding.myProgress.max=10
//        binding.myProgress.progress=8
        ObjectAnimator.ofInt(binding.myProgress,"P",0,10).apply {
            duration=3000
        }.start()
    }
}