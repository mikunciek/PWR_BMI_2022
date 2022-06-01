package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class libraryPDF : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_pdf)


        val nutrion: Button = findViewById(R.id.nutrion)
        nutrion.setOnClickListener {
            this.startActivity(Intent(this, newNutrion::class.java))

        }

        val rehydration: Button = findViewById(R.id.rehydration)
        rehydration.setOnClickListener {
            this.startActivity(Intent(this, rehydrationActivity::class.java))

        }

        val grill: Button = findViewById(R.id.grill)
        grill.setOnClickListener {
            this.startActivity(Intent(this, grillHealthy::class.java))

        }

        val challenge: Button = findViewById(R.id.challenge)
        challenge.setOnClickListener {
            this.startActivity(Intent(this, daysChallenge::class.java))

        }

        val memory: Button = findViewById(R.id.memory)
        memory.setOnClickListener {
            this.startActivity(Intent(this, memoryGood::class.java))

        }
    }
}