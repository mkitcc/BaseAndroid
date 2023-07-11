package org.itsman.baseandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.itsman.baseandroid.R
import org.itsman.tools.toast
import org.itsman.baseandroid.viewmodel.UserProfileViewModel
import org.itsman.network.HttpClient
import org.itsman.network.QuoteList

class MainActivity : AppCompatActivity() {

    private val user: UserProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Show(name = "Hello World") {
                toast(this@MainActivity, "compose view")
            }
        }
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                toast(this@MainActivity, "lifecycleOwner")
            }
        })
        val handler = Handler(Looper.getMainLooper()) {
            if (it.what == 1) {

            }
            false
        }
        handler.sendEmptyMessage(10)
        WindowCompat.getInsetsController(window, window.decorView)
            .hide(WindowInsetsCompat.Type.systemBars())
        getData()
    }

    private fun getData() {
        GlobalScope.launch {
            val result2 = HttpClient.getInstance().getQuotes2()
            result2.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this@MainActivity::showData, this@MainActivity::showErr)
        }

    }

    private fun showData(result: QuoteList) {
        Log.d("Rxjava", result.toString())
    }

    private fun showErr(err: Throwable) {

    }

    @Composable
    fun Show(name: String, onClick: () -> Unit): Unit {
        Column(
            Modifier
                .clickable(onClick = onClick)
                .padding(22.dp)
                .background(color = Color.Green)
        ) {
            Text(text = "hello world", Modifier.padding(10.dp))
            Text(text = "hello world", Modifier.padding(10.dp))
            Text(text = "hello world", Modifier.padding(10.dp))
            Divider(color = Color.Black)
            Image(
                painter = painterResource(id = R.drawable.asdf),
                contentDescription = null
            )
        }
    }
}
