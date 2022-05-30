package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class showResultQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result_quiz)


        val back: Button = findViewById(R.id.backMenu)
        back.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
    }
}