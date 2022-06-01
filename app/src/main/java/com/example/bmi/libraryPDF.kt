package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_library_pdf.*

class libraryPDF : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_pdf)

        nutrion.setOnClickListener {
            this.startActivity(Intent(this, newNutrion::class.java))

        }

        rehydration.setOnClickListener {
            this.startActivity(Intent(this, rehydrationActivity::class.java))

        }

        grill.setOnClickListener {
            this.startActivity(Intent(this, grillHealthy::class.java))

        }

        challenge.setOnClickListener {
            this.startActivity(Intent(this, daysChallenge::class.java))

        }

        memory.setOnClickListener {
            this.startActivity(Intent(this, memoryGood::class.java))

        }
    }
}