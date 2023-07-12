package org.itsman.baseandroid.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.itsman.baseandroid.ui.compose.Show
import org.itsman.baseandroid.viewmodel.UserProfileViewModel
import org.itsman.network.HttpClient
import org.itsman.network.QuoteList
import org.itsman.tools.toast

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
            if (it.what == 1204) {
                toast(this, "handler")
            }
            false
        }
        handler.sendEmptyMessageDelayed(1204, 5000)
        handler.sendEmptyMessage(1023)
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
        Log.e("Rxjava", "Error")
    }


}
