package org.itsman.fastlibrary.tools

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import org.itsman.fastlibrary.databinding.AcWebViewBinding


class MyWebView : AppCompatActivity() {

    companion object {
        const val URL = "url"
    }

    lateinit var url: String

    val bind: AcWebViewBinding by lazy {
        AcWebViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        initParams()
        initView()
    }

    fun initParams() {
        url = intent.getStringExtra(URL).toString()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initView() {

        bind.web.loadUrl(url)

        //声明WebSettings子类
        val webSettings: WebSettings = bind.web.getSettings()
        //不使用缓存:
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.javaScriptEnabled = true
        webSettings.allowFileAccess = true; //设置可以访问文件
        webSettings.javaScriptCanOpenWindowsAutomatically = true; //支持通过JS打开新窗口
        webSettings.loadsImagesAutomatically = true; //支持自动加载图片
        webSettings.defaultTextEncodingName = "utf-8";//设置编码格式

        bind.web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?, url: String
            ): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
    }

    override fun onDestroy() {
        (bind.web.parent as ViewGroup).removeView(bind.web)
        bind.web.destroy()
        super.onDestroy()
    }

}