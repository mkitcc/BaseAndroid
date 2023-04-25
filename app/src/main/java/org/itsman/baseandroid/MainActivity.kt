package org.itsman.baseandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.itsman.baseandroid.network.HttpClient
import org.itsman.baseandroid.network.QuoteList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

}
