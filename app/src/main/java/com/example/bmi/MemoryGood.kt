package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*

class MemoryGood : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_good)

        val webView: WebView = findViewById(R.id.panel)
        val url ="https://github.com/mikunciek/PWR_BMI_2022/raw/master/pdf/Dieta%20dobra%20na%20pamie%C4%87.pdf"

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.isVerticalScrollBarEnabled = true
        webView.canGoBack()
        webView.canGoForward()
        webView.requestFocus()
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
    }
}