package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_result_quiz.*


class ShowResultQuiz : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result_quiz)


        val point = this.intent.getStringExtra("Punkty")


        layoutResoult.text = "Twój wynik:  $point"

        backMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }

        library.setOnClickListener {
            this.startActivity(Intent(this, LibraryPDF::class.java))
        }
    }
}