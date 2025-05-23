package org.itsman.fastlibrary.ui.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.apache.poi.xslf.usermodel.XMLSlideShow
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
}