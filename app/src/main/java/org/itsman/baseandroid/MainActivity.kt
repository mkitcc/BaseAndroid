package org.itsman.baseandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.itsman.baseandroid.Tools.toast
import org.itsman.network.HttpClient
import org.itsman.network.QuoteList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent {
            Show(name = "Hello World") {
                toast(this@MainActivity)
            }
        }
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
            Image(
                painter = painterResource(id = R.drawable.asdf),
                contentDescription = null
            )
        }
    }
}
