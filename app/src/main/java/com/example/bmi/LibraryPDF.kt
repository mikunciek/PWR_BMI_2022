package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_library_pdf.*
import kotlinx.android.synthetic.main.activity_library_pdf.backMainMenu


@Suppress("ClassName")
class LibraryPDF : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_pdf)

        nutrion.setOnClickListener {
            this.startActivity(Intent(this, NewNutrion::class.java))

        }

        rehydration.setOnClickListener {
            this.startActivity(Intent(this, RehydrationActivity::class.java))

        }

        grill.setOnClickListener {
            this.startActivity(Intent(this, GrillHealthy::class.java))

        }

        challenge.setOnClickListener {
            this.startActivity(Intent(this, DaysChallenge::class.java))

        }

        memory.setOnClickListener {
            this.startActivity(Intent(this, MemoryGood::class.java))

        }
        //akcje powrotu

        backMainMenu.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))
        }
    }
}