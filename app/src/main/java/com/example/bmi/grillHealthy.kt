package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*

class grillHealthy : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grill_healthy)


        val webView: WebView = findViewById(R.id.panel)

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        webView.isVerticalScrollBarEnabled = true; //przewijanie w pionie
        webView.canGoBack()
        webView.canGoForward()
        webView.requestFocus()
        val url ="https://github.com/mikunciek/PWR_BMI_2022/raw/master/pdf/Zasady%20zdrowego%20grillowania.pdf"
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
    }
}