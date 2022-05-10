package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate: Button = findViewById(R.id.calculate)
        calculate.setOnClickListener {
            this.startActivity(Intent(this, calculateBMI::class.java))
        }

        val reading: Button = findViewById(R.id.reading)
        reading.setOnClickListener{
            this.startActivity(Intent(this, viewPDF::class.java))
        }
    }




}