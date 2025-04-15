package org.itsman.fastlibrary.tools

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class MyWebView : AppCompatActivity(){

    companion object{
        const val URL="url"
    }

    lateinit var url:String
    lateinit var web: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParams()
        initView()
    }

    fun initParams(){
        url= intent.getStringExtra(URL).toString()
    }

    fun initView(){
        web = WebView(this)
        setContentView(web)
        val lp = web.layoutParams
        lp.width= ViewGroup.LayoutParams.MATCH_PARENT
        lp.height= ViewGroup.LayoutParams.MATCH_PARENT
        web.layoutParams=lp
        web.loadUrl(url)
    }

}