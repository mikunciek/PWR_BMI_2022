package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_show_result_quiz.*
import com.example.bmi.quizLife as quizLife1


class showResultQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result_quiz)



       // var point = quizLife1
       // val points = point.sumPoint


        layoutResoult.text = "Twój wynik: "


        val back: Button = findViewById(R.id.backMenu)
        back.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }


        val library: Button = findViewById(R.id.library)
        library.setOnClickListener {
            this.startActivity(Intent(this, libraryPDF::class.java))
        }
    }

}