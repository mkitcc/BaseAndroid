package org.itsman.fastlibrary.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityNavigationBinding

class NavigationActivity : BaseActivity() {

    private lateinit var bind: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    companion object {
        fun start(c: Context) {
            val intent = Intent(c, NavigationActivity::class.java)
            c.startActivity(intent)
        }
    }
}