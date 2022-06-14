package com.example.bmi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener {
            this.startActivity(Intent(this, CalculateBMI::class.java))
        }
        reading.setOnClickListener{
            this.startActivity(Intent(this, LibraryPDF::class.java))
        }

        quizO.setOnClickListener {
            this.startActivity(Intent(this, QuizLife::class.java))
        }

        previous.setOnClickListener {
            this.startActivity(Intent(this, PreviousTable::class.java))
        }
    }
}