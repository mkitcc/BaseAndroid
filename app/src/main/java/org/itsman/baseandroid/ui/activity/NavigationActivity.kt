package org.itsman.baseandroid.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itsman.baseandroid.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

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