package com.example.mirzo_golibsuvonberdiev.parcel.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.mirzo_golibsuvonberdiev.parcel.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        web_layout.webViewClient = MyWebViewClient()
        web_layout.loadUrl("https://google.com")

    }

    class MyWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}
