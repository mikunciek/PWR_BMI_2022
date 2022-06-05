package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculate_bmi.*
import kotlinx.android.synthetic.main.activity_library_pdf.*
import kotlinx.android.synthetic.main.activity_library_pdf.backMainMenu


@Suppress("ClassName")
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
        //akcje powrotu

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
    }
}