package com.example.bmi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_show_result_quiz.*
import com.example.bmi.quizLife as quizLife1


class showResultQuiz : AppCompatActivity() {
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
            this.startActivity(Intent(this, libraryPDF::class.java))
        }
    }
}