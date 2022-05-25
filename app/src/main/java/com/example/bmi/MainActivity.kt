package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //StartButton - import kotlinx.android.synthetic.main.activity_main.*
        //StopButton - nie trzeba deklarować zmiennej wcześniej
        val calculate: Button = findViewById(R.id.calculate)
        calculate.setOnClickListener {
            this.startActivity(Intent(this, calculateBMI::class.java))
        }

        val reading: Button = findViewById(R.id.reading)
        reading.setOnClickListener{
            this.startActivity(Intent(this, viewPDF::class.java))
        }

        val quiz: Button = findViewById(R.id.quizOpen)
        quiz.setOnClickListener {
            this.startActivity(Intent(this, quizLife::class.java))
        }


        val previous: Button = findViewById(R.id.previous)
        previous.setOnClickListener {
            this.startActivity(Intent(this, previousTable::class.java))
        }



    }




}