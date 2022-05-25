package com.example.bmi

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_nutrion.*

class newNutrion : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_nutrion)

        val webView: WebView = findViewById(R.id.panel)

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        webView.isVerticalScrollBarEnabled = true; //przewijanie w pionie
        webView.canGoBack()
        webView.canGoForward()
        webView.requestFocus()
        val url =
           // "https://github.com/mikunciek/PWR_BMI_2022/raw/master/pdf/Dieta%20dobra%20na%20pamie%C4%87.pdf"
            "https://github.com/mikunciek/PWR_BMI_2022/raw/master/pdf/Talerz%20Zdrowego%20%C5%BBywienia.pdf"
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")

/*
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        WebSettings.PluginState.ON.also { webSettings.pluginState = it }
        webSettings.setGeolocationEnabled(true)
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.builtInZoomControls = true
        webSettings.saveFormData = true
        webSettings.setAppCacheEnabled(true)
        webSettings.databaseEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadsImagesAutomatically = true
        webSettings.allowFileAccess = true
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.allowUniversalAccessFromFileURLs = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true
        webSettings.setGeolocationDatabasePath(filesDir.path)
        webSettings.allowFileAccess = true
        webSettings.allowUniversalAccessFromFileURLs = true

*/

    }
}

