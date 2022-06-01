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

        calculate.setOnClickListener {
            this.startActivity(Intent(this, calculateBMI::class.java))
        }

        reading.setOnClickListener{
            this.startActivity(Intent(this, libraryPDF::class.java))
        }


        quizOpen.setOnClickListener {
            this.startActivity(Intent(this, quizLife::class.java))
        }


        previous.setOnClickListener {
            this.startActivity(Intent(this, previousTable::class.java))
        }



    }




}