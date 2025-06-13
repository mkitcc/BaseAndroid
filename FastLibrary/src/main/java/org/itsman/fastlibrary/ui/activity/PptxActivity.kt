package org.itsman.fastlibrary.ui.activity

import android.os.Bundle
import android.view.MotionEvent
import androidx.lifecycle.lifecycleScope
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.TransitionManager
import kotlinx.coroutines.launch
import org.itsman.fastlibrary.R
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityPptxBinding

class PptxActivity : BaseActivity() {

    lateinit var bind: ActivityPptxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityPptxBinding.inflate(layoutInflater)
        setContentView(bind.root)

        lifecycleScope.launch {
            val aa = assets.open("DEMO.pptx")
//            XMLSlideShow(aa).use { slides ->
//                for (slide in slides.slides) {
//                    slide::getTitle
//                }
//            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (MotionEvent.ACTION_DOWN==event?.action){
            switch()
        }
        return super.onTouchEvent(event)
    }
    fun switch(){
        // 1. 定义两个布局文件 scene1.xml 和 scene2.xml

// 2. 加载场景并设置过渡动画
        val scene1 = Scene.getSceneForLayout(bind.fl, R.layout.activity_test, this)
        val scene2 = Scene.getSceneForLayout(bind.fl, R.layout.activity_main, this)

// 设置过渡效果
        val fadeTransition = Fade()
        fadeTransition.duration = 500

// 切换场景
        TransitionManager.go(scene2, fadeTransition)
    }
}